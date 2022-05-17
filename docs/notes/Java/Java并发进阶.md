---
title: Java并发进阶
icon:
category: Java
tag:
  - 线程池
  - 并发容器
---
<!-- GFM-TOC --> 
* [八、任务取消与关闭](#八任务取消与关闭)
  * [任务取消](#任务取消)
    * [中断](#中断)
    * [通过Future来取消](#通过future来取消)
    * [处理不可中断的阻塞](#处理不可中断的阻塞)
    * [采用newTaskFor来封装非标准化的取消](#采用newtaskfor来封装非标准化的取消)
    * [停止基于线程的服务](#停止基于线程的服务)
    * [ExecutorService 中的关闭](#executorservice-中的关闭)
  * [JVM关闭](#jvm关闭)
* [九、Java并发容器](#九java并发容器)
  * [ConcurrentHashMap](#concurrenthashmap)
  * [CopyOnWriteArrayList](#copyonwritearraylist)
    * [读取操作实现](#读取操作实现)
    * [写入操作实现](#写入操作实现)
  * [ConcurrentLinkedQueue](#concurrentlinkedqueue)
  * [BlockingQueue](#blockingqueue)
    * [Java里的BlockingQueue](#java里的blockingqueue)
    * [BlockingQueue实现原理](#blockingqueue实现原理)
  * [ConcurrentSkipListMap](#concurrentskiplistmap)
* [十、线程池和Executor框架](#十线程池和executor框架)
  * [线程池](#线程池)
    * [实现原理](#实现原理)
    * [线程池的使用](#线程池的使用)
  * [Executor框架](#executor框架)
    * [两级调度模型](#两级调度模型)
    * [框架结构](#框架结构)
    * [框架使用](#框架使用)
    * [Executor框架的成员](#executor框架的成员)
    * [ThreadPoolExecutor详解](#threadpoolexecutor详解)
    * [ScheduledThreadPoolExecutor详解](#scheduledthreadpoolexecutor详解)
    * [FutureTask详解](#futuretask详解)
  * [Fork/Join框架](#forkjoin框架)
    * [Fork/Join框架的设计](#forkjoin框架的设计)
    * [Fork/Join框架的使用](#forkjoin框架的使用)
    * [Fork/Join框架的实现原理](#forkjoin框架的实现原理)
* [参考资料](#参考资料)
<!-- GFM-TOC -->

# 八、任务取消与关闭

要使任务和线程安全、快速、可靠的停止下来，并不是一件容易的事情。java没有提供任何机制来安全地终止线程，但提供了中断协作机制，中断能使一个线程终止另一个线程的当前工作。

## 任务取消

- 如果外部代码能在某个操作正常完成之前将其置入“完成”状态，那么这个操作就可以成为可取消的。
- 在java中没有一种安全的抢占式方法来停止线程，因此也就没有安全的抢占式方法来停止任务。只有一些协作式的机制，使请求取消的任务和代码都遵循一种协商好的协议。
- 一个可取消的任务必须拥有「取消策略」：规定How(如何取消)，When(什么时候检测取消)和What(如何处理取消)。

如何取消一般有两种方法：
- 使用volatile类型状态变量(不一定可靠)：线程中循环遍历状态变量，检测是否需要结束当前线程。通过不断查看volatile类型的状态变量是一种简单的取消策略，然而，如果任务除了检查状态变量外执行了阻塞方法，任务可能永远不会检查取消状态标志，此时永远不会结束任务。
- 使用中断(最合理的方法)：系统提供的大多数阻塞方法响应中断：清除中断状态，抛出InterruptedException异常，表示阻塞操作由于中断而提前结束。


### 中断

- 通常，中断是实现取消的最合理方式
- 在取消之外的操作中使用中断，都是不合适的，并且很难支撑起更大的应用。
- 调用 interrupt() 并不意味着立即停止目标线程正在进行的工作，而只是传递了请求中断的消息

中断的正确理解是，它并不会真正地中断一个正在运行的线程，而只是发出中断请求，然后由线程在下一个合适的时刻中断自己(这些时刻被称为取消点)。

```java
public class Thread {
    public void interrupt() { ...}  //请求中断，设置线程的中断标记

    public boolean isInterrupted() {...} //返回线程中断状态

    public static boolean interrupted() {...} //若返回true原有的中断状态会被清除，除非想屏蔽中断，必否则须对其作出处理：可以抛出InterruptedException异常，也可再次调用interrupt来恢复中断
}
```
**中断策略**

- 最合理的中断策略是某种形式的线程级取消操作或服务及取消操作：尽快退出，在必要时进行清理，通知某个所有者该线程已经退出。
- 一个中断请求可以有一个或多个接受者。
- 大多数可阻塞库函数只抛出InterruptedException作为中断响应，也是最合理的取消策略：尽快退出执行流程并把中断信息传递给调用者，从而使栈中的上层代码可以采取进一步的操作。
- 由于每个线程拥有各自的中断策略，除非知道中断对该线程的含义，否则就不应该中断这个线程。

当线程在活动之前或活动期间处于正在等待、休眠或占用状态且该线程被中断时，抛出该异常InterruptedException

抛 InterruptedException 的代表方法有：
- java.lang.Object 类的 wait 方法
- java.lang.Thread 类的 sleep 方法
- java.lang.Thread 类的 join 方法

**响应中断**

当调用可中断的阻塞函数，例如Thread.sleep等，有两种实用策略可用于处理InterruptedException：
1. 传递异常(可能在执行某个特定于任务的清除操作之后)：从而使你的方法也成为可中断的阻塞方法
2. 恢复中断状态：从而使调用栈的上层代码能对其进行处理


如果你不想或无法传递InterruptedException(或许通过Runnable来定义任务)，一种标准方法是再次调用interrupt来恢复中断，不能屏蔽InterruptedException。

- 只有实现了线程中断策略的代码才可以屏蔽中断请求，在常规的任务和库代码中都不应该屏蔽中断请求。
- 如果代码不会调用可中断的阻塞方法，那么仍然可以通过在任务代码中轮询当前线程的中断状态来响应中断。
- join的不足：无法知道执行控制是因为线程正常退出而返回还是因为join超时而返回。

### 通过Future来取消

ExecutorService.submit将返回一个Future来描述任务，

- 执行任务的线程是由Executor创建的，实现了一种中断策略使得任务可以通过中断被取消，
- 当尝试取消某个任务时，不宜直接中断线程池，因为并不知道当中断请求到达时正在运行什么任务，只能通过任务的Future来实现取消。
- 当Future.get抛出InterruptedException或TimeoutException时，如果知道不再需要结果，就可以调用Future.cancel来取消任务。

### 处理不可中断的阻塞

对于那些由于执行不可中断操作而被阻塞的线程，可以使用类似于中断的手段来停止这些线程，但要求知道线程阻塞的原因。

常见的不可阻塞中断包括
- Java.io包中的Socket I/O
- Java.io包中的同步I/O
- Selector的异步I/O
- 获取某个锁

### 采用newTaskFor来封装非标准化的取消

### 停止基于线程的服务

- 如果硬要程序准备退出，那么这些服务所拥有的线程也需要结束。
- 正确的封装原则是，除非拥有某个线程，否则不能对该线程进行操控。
- 对于持有线程的服务，只要服务的存在时间大于创建线程的方法的存在时间，那么就应该提供生命周期方法。

### ExecutorService 中的关闭

- 正常关闭：shutdown() 方法会等待线程都执行完毕之后再关闭
- 强行关闭：shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法，无法通过常规方法来找出哪些任务已经开始但尚未结束

## JVM关闭

**关闭钩子**
- 指通过Runtime.addShutdownHook注册的但尚未开始的线程。
- 不应该依赖可能被应用程序或其他关闭钩子关闭的服务，对所有服务使用同一个关闭钩子，各个关闭操作串行执行。

**守护线程**
- 应尽可能少地使用守护线程，很少有操作能够在不进行清理的情况下被安全地抛弃。
- 守护线程通常不能用来替代应用程序管理中各个服务的生命周期。

**终结器**
- 避免使用。

# 九、Java并发容器

## ConcurrentHashMap

ConcurrentHashMap是线程安全且高效的HashMap。

在并发编程中使用HashMap可能导致程序死循环。而使用线程安全的HashTable效率又非常低下，基于以上两个原因，便有了ConcurrentHashMap。

- 线程不安全的HashMap  
在多线程环境下，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。例如，执行以下代码会引起死循环

- 效率低下的HashTable  
HashTable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下HashTable的效率非常低下。因为当一个线程访问HashTable的同步方法，其他线程也访问HashTable的同步方法时，会进入阻塞或轮询状态。

- ConcurrentHashMap的锁分段技术可有效提升并发访问率  
HashTable容器在竞争激烈的并发环境下表现出效率低下的原因是所有访问HashTable的线程都必须竞争同一把锁，假如容器里有多把锁，每一把锁用于锁容器其中一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，从而可以有效提高并发访问效率，这就是ConcurrentHashMap所使用的锁分段技术。首先将数据分成一段一段地存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。

**ConcurrentHashMap的结构**

ConcurrentHashMap是由Segment数组结构和HashEntry数组结构组成。Segment是一种可重入锁(ReentrantLock)，在ConcurrentHashMap里扮演锁的角色；HashEntry则用于存储键值对数据。一个ConcurrentHashMap里包含一个Segment数组。Segment的结构和HashMap类似，是一种数组和链表结构。一个Segment里包含一个HashEntry数组，每个HashEntry是一个链表结构的元素，每个Segment守护着一个HashEntry数组里的元素，当对HashEntry数组的数据进行修改时，必须首先获得与它对应的Segment锁，

<div align="center"> 

![](../../assets/cs-note/java-concurrent/ConcurrentHashMap的结构图.png ':size=500')
</div>

## CopyOnWriteArrayList

在很多应用场景中，读操作可能会远远大于写操作。由于读操作根本不会修改原有的数据，因此对于每次读取都进行加锁其实是一种资源浪费。我们应该允许多个线程同时访问List的内部数据，毕竟读取操作是安全的。

ReentrantReadWriteLock 读写锁的思想非常类似，也就是读读共享、写写互斥、读写互斥、写读互斥。JDK中提供了 CopyOnWriteArrayList 类比相比于在读写锁的思想又更进一步。为了将读取的性能发挥到极致，CopyOnWriteArrayList 读取是完全不用加锁的，并且更厉害的是：写入也不会阻塞读取操作。只有写入和写入之间需要进行同步等待。

### 读取操作实现

读取操作没有任何同步控制和锁操作，理由就是内部数组 array 不会发生修改，只会被另外一个 array 替换，因此可以保证数据安全。
```java
    /** The array, accessed only via getArray/setArray. */
    private transient volatile Object[] array;
    public E get(int index) {
        return get(getArray(), index);
    }
    @SuppressWarnings("unchecked")
    private E get(Object[] a, int index) {
        return (E) a[index];
    }
    final Object[] getArray() {
        return array;
    }
```

### 写入操作实现

CopyOnWriteArrayList 写入操作 add() 方法在添加集合的时候加了锁，保证了同步，避免了多线程写的时候会 copy 出多个副本出来。

```java
    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();//加锁
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);//拷贝新数组
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();//释放锁
        }
    }
```
## ConcurrentLinkedQueue

Java提供的线程安全的 Queue 可以分为阻塞队列和非阻塞队列，其中阻塞队列的典型例子是 BlockingQueue，非阻塞队列的典型例子是ConcurrentLinkedQueue，在实际应用中要根据实际需要选用阻塞队列或者非阻塞队列。 阻塞队列可以通过加锁来实现，非阻塞队列可以通过 CAS 操作实现。

ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规则对节点进行排序，当我们添加一个元素的时候，它会添加到队列的尾部；当我们获取一个元素时，它会返回队列头部的元素。它采用了“wait-free”算法(即CAS算法)来实现。

**ConcurrentLinkedQueue的结构**：
ConcurrentLinkedQueue由head节点和tail节点组成，每个节点(Node)由节点元素(item)和指向下一个节点(next)的引用组成，节点与节点之间就是通过这个next关联起来，从而组成一张链表结构的队列。

ConcurrentLinkedQueue 适合在对性能要求相对较高，同时对队列的读写存在多个线程同时进行的场景，即如果对队列加锁的成本较高则适合使用无锁的ConcurrentLinkedQueue来替代。

## BlockingQueue

阻塞队列(BlockingQueue)是一个支持两个附加操作的队列。这两个附加的操作支持阻塞的插入和移除方法。
- 支持阻塞的插入方法：当队列满时，队列会阻塞插入元素的线程，直到队列不满。
- 支持阻塞的移除方法：当队列空时，获取元素的线程会等待队列变为非空。

插入和移除操作的4种处理方式

| 方法/处理方式 | 抛出异常  | 返回特殊值 | 一直阻塞 | 超时退出             |
| ------------- | --------- | ---------- | -------- | -------------------- |
| 插入方法      | add(e)    | offer(e)   | put(e)   | offer(e, time, unit) |
| 移除方法      | remove()  | poll()     | take()   | poll(time, unit)     |
| 检查方法      | element() | peek()     | 不可用   | 不可用               |

- 抛出异常：当队列满时，如果再往队列里插入元素会抛出IllegalStateException("Queue full")异常。当队列空时，从队列里获取元素会抛出NoSuchElementException异常。
- 返回特殊值：当往队列插入元素时，会返回元素是否插入成功，成功返回true。如果是移除方法，则从队列里取出一个元素，如果没有则返回null。
- 一直阻塞：当阻塞队列满时，如果生产者线程往队列里put元素，队列会一直阻塞生产者线程，直到队列可用或者响应中断退出。当队列空时，如果消费者线程从队列列take元素，队列会阻塞消费者线程，直到队列不为空。
- 超时退出：当阻塞队列满时，如果生产者线程往队列里插入元素，队列会阻塞生产者线程一段时间，如果超时则退出。

如果是无界阻塞队列，队列不可能会出现满的情况，所以使用put或offer方法永远不会被阻塞，而且使用offer方法时，该方法永远返回true

### Java里的BlockingQueue

- ArrayBlockingQueue：用数组实现的有界阻塞队列，按FIFO原则对元素进行排序。
  - 一旦创建，容量不能改变  
  - 并发控制采用可重入锁来控制，不管是插入操作还是读取操作，都需要获取到锁才能进行操作
  - 默认情况下不能保证线程访问队列的公平性,(所谓公平性是指严格按照线程等待的绝对时间顺序，即最先等待的线程能够最先访问到 ArrayBlockingQueue。)为了保证公平性，通常会降低吞吐量
- LinkedBlockingQueue：用**单向链表**实现的有界阻塞队列，默认和最大长度为Integer.MAX_VALUE，按FIFO原则对元素进行排序。
  - 与ArrayBlockingQueue 相比起来具有更高的吞吐量，为了防止 LinkedBlockingQueue 容量迅速增，损耗大量内存。通常在创建LinkedBlockingQueue 对象时，会指定其大小，如果未指定，容量等于Integer.MAX_VALUE。
- PriorityBlockingQueue：支持优先级的无界阻塞队列，默认情况下元素采取自然顺序升序排列。不保证同优先级元素的顺序。
  -  并发控制采用的是 ReentrantLock
  -  只能指定初始的队列大小，后面插入元素的时候，如果空间不够的话会自动扩容)
  -  PriorityQueue 的线程安全版本。不可以插入 null 值，同时，插入队列的对象必须是可比较大小的(comparable)，否则报 ClassCastException 异常
  -  它的插入操作 put 方法不会 block，因为它是无界队列(take 方法在队列为空的时候会阻塞)
- DelayQueue：支持延时获取元素的无界阻塞队列。队列使用PriorityQueue实现，队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才能从队列中提取元素。可应用于：
    - 缓存系统的设计：用DelayQueue保存缓存元素的有效期，使用一个线程循环查询DelayQueue，一旦能从DelayQueue中获取元素表示缓存有效期到了。
    - 定时任务调度：使用DelayQueue保存当天将会执行的任务和执行时间，一旦从DelayQueue中获取到任务就开始执行，比如TimerQueue就是使用DelayQueue实现的。
- SynchronousQueue：不存储元素的阻塞队列。每一个put操作必须等待一个take操作，否则不能继续添加元素。
- LinkedTransferQueue：链表结构组成的无界阻塞TransferQueue队列。相对于其他阻塞队列，LinkedTransferQueue多了tryTransfer和transfer方法。
    - transfer方法：如果当前有消费者正在等待接收元素，transfer方法可以把生产者传入的元素立刻传给消费者。如果没有消费者在等待接收元素，则将元素存放在队列tail节点并等到钙元素被消费者消费了才返回。
    - tryTransfer方法：如果没有消费者等待接收元素，则立即返回false。
- LinkedBlockingDeque：链表结构组成的双向阻塞队列。

### BlockingQueue实现原理

使用通知模式实现。所谓通知模式，就是当生产者往满的队列里添加元素时会阻塞住生产者，当消费者消费了一个队列中的元素后，会通知生产者当前队列可用。

## ConcurrentSkipListMap

**跳表**

对于一个单链表，即使链表是有序的，如果我们想要在其中查找某个数据，也只能从头到尾遍历链表，这样效率自然就会很低，跳表就不一样了。跳表是一种可以用来快速查找的数据结构，有点类似于平衡树。它们都可以对元素进行快速的查找。但一个重要的区别是：对平衡树的插入和删除往往很可能导致平衡树进行一次全局的调整。而对跳表的插入和删除只需要对整个数据结构的局部进行操作即可。这样带来的好处是：在高并发的情况下，你会需要一个全局锁来保证整个平衡树的线程安全。而对于跳表，你只需要部分锁即可。这样，在高并发环境下，你就可以拥有更好的性能。而就查询的性能而言，跳表的时间复杂度也是 O(logn) 所以在并发数据结构中，JDK 使用跳表来实现一个 Map。

跳表的本质是同时维护了多个链表，并且链表是分层的，

<div align="center"> 

![](../../assets/cs-note/java-concurrent/跳表结构.png ':size=500')
</div>

最低层的链表维护了跳表内所有的元素，每上面一层链表都是下面一层的子集。

跳表内的所有链表的元素都是排序的。查找时，可以从顶级链表开始找。一旦发现被查找的元素大于当前链表中的取值，就会转入下一层链表继续找。这也就是说在查找过程中，搜索是跳跃式的。

<div align="center"> 

![](../../assets/cs-note/java-concurrent/跳表查找.png ':size=500')
</div>

查找18 的时候原来需要遍历 18 次，现在只需要 7 次即可。针对链表长度比较大的时候，构建索引查找效率的提升就会非常明显。

从上面很容易看出，跳表是一种利用空间换时间的算法。

使用跳表实现Map 和使用哈希算法实现Map的另外一个不同之处是：哈希并不会保存元素的顺序，而跳表内所有的元素都是排序的。因此在对跳表进行遍历时，你会得到一个有序的结果。所以，如果你的应用需要有序性，那么跳表就是你不二的选择。JDK 中实现这一数据结构的类是ConcurrentSkipListMap。

# 十、线程池和Executor框架

## 线程池

> 池化技术想必大家已经屡见不鲜了，线程池、数据库连接池、Http 连接池等等都是对这个思想的应用。池化技术的思想主要是为了减少每次获取资源的消耗，提高对资源的利用率。

Java中的线程池是运用场景最多的并发框架，几乎所有需要异步或并发执行任务的程序都可以使用线程池。

在开发过程中，合理地使用线程池能够带来3个好处:
- 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
- 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。但是，要做到合理利用线程池，必须对其实现原理了如指掌。

### 实现原理

当提交一个新任务到线程池时，线程池的处理流程如下。
1. 线程池判断核心线程池里的线程是否都在执行任务。如果不是，则创建一个新的工作线程来执行任务。如果核心线程池里的线程都在执行任务，则进入下个流程。
2. 线程池判断工作队列是否已经满。如果工作队列没有满，则将新提交的任务存储在这个工作队列里。如果工作队列满了，则进入下个流程。
3. 线程池判断线程池的线程是否都处于工作状态。如果没有，则创建一个新的工作线程来执行任务。如果已经满了，则交给饱和策略来处理这个任务

线程池的主要处理流程如图

<div align="center"> 

![](../../assets/cs-note/java-concurrent/线程池的主要处理流程.png ':size=500')
</div>

ThreadPoolExecutor执行execute方法分下面4种情况：
1. 如果当前运行的线程少于corePoolSize，则创建新线程来执行任务
2. 如果运行的线程等于或多于corePollSize，则将任务加入BlockingQueue
3. 如果无法将任务加入BlockingQueue(队列已满)，则创建新的线程来处理任务
4. 如果创建新线程将导致当前运行的线程数超过maximumPoolSize，任务将被拒绝，并调用RejectedExecutionHandler.rejectedExecution()方法。

程池中的线程执行任务分两种情况，如下：
1. 在execute()方法中创建一个线程时，会让这个线程执行当前任务。
2. 这个线程执行完一个任务后，会反复从BlockingQueue获取任务来执行。

### 线程池的使用

通过ThreadPoolExecutor来**创建**一个线程池

```java
    new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, milliseconds,runnableTaskQueue, handler);
```
1. corePoolSize(线程池的基本大小)：当提交一个任务到线程池时，线程池会创建一个线程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，直到需要执行的任务数大于线程池基本大小。如果调用了线程prestartAllCoreThreads()方法，线程池会提前创建并启动所有基本线程。
2. runnableTaskQueue(任务队列)：用于保存等待执行的任务的阻塞队列。可以选择ArratBlockingQueue, LinkedBlockingQueue, SynchronousQueue, PriorityBlockingQueue。
3. maximumPoolSize(线程池最大数量)：线程池允许创建的最大线程数。
4. ThreadFactory：用于设置创建线程的工厂，可以通过线程工厂给每个创建出来的线程设置更有意义的名字。
5. RejectedExecutionHandler(饱和策略)：当队列和线程池都满了，说明线程池处于饱和状态，那么必须采取一种策略处理提交的新任务。这个策略默认情况下是AbortPolicy，表示无法处理新任务时抛出异常。策略有下列几种：
   - AbortPolicy：直接抛出异常
   - CallerRunsPolicy：只用调用者所在线程来运行任务。
   - DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务。
   - DiscardPolicy：不处理，丢弃掉。
   - 其他应用场景需要实现RejectedExecutionHandler接口自定义。
6. keepAliveTime(线程活动保持时间)：线程池的工作线程空闲后，保持存活的时间。如果任务多且执行时间短，可以调高存活时间提高线程利用率。
7. TimeUnit(线程活动保持时间的单位)

向线程池**提交任务**有两种方式：
- execute(Runnable command)：方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
- submit(Callable task)：方法用于提交需要返回值的任务。线程池会返回一个 Future 类型的对象，通过这个 Future 对象可以判断任务是否执行成功，并且可以通过 Future 的 get()方法来获取返回值，get()方法会阻塞当前线程直到任务完成，而使用 get(long timeout，TimeUnit unit)方法则会阻塞当前线程一段时间后立即返回，这时候有可能任务没有执行完。

线程池的**关闭**有两种方法：
- shutdown()：关闭线程池，线程池的状态变为 SHUTDOWN。线程池不再接受新任务了，但是队列里的任务得执行完毕。
- shutdownNow()：关闭线程池，线程的状态变为 STOP。线程池会终止当前正在运行的任务，并停止处理排队的任务并返回正在等待执行的 List。

**查询关闭**状态
- isShutDown 当调用 shutdown() 方法或 shutdownNow() 后返回为 true。
- isTerminated 当调用 shutdown() 方法后，并且所有提交的任务完成后返回为 true；当且仅当所有任务都关闭，CIA表示线程池关闭成功，这是isTerminaed()方法才会返回true。


**合理配置线程池**(设N为CPU个数)
- CPU密集型任务，应配置尽可能少的线程，如N+1。
- IO密集型任务，应配置尽可能多的线程，如2N。
- 优先级不同的任务可以考虑使用优先级队列priorityBlockingQueue来处理，但优先级低的任务可能永远不被执行。
- 使用有界队列能增加系统的稳定性和预警性，避免队列越来越多撑满内存，导致系统不可用。

**线程池的监控**:
监控线程池的时候可以使用以下属性：
- taskCount：线程池需要执行的任务数量。
- completedTaskCount：线程池在运行过程中已完成的任务数量，小于或等于taskCount。
- largestPoolSize：线程池里曾经创建过的最大线程数量。通过这个数据可以知道线程池是否曾经满过。
- getPoolSize：线程池的线程数量。如果线程池不销毁的话，线程池里的线程不会自动销毁，所以这个大小只增不减。
- getActiveCount：获取活动的线程数。

可以通过继承线程池来自定义线程池，重写线程池的beforeExecute, afterExecute和terminated方法，也可以在任务执行前后和线程池关闭前执行一些代码来进行监控。例如，监控任务的平均执行时间、最大执行时间和最小执行时间等。这几个方法在线程池里都是空方法。

## Executor框架

在Java中，使用线程来异步执行任务。Java线程的创建与销毁需要一定的开销，如果我们为每一个任务创建一个新线程来执行，这些线程的创建与销毁将消耗大量的计算资源。同时，为每一个任务创建一个新线程来执行，这种策略可能会使处于高负荷状态的应用最终崩溃。

Java的线程既是工作单元，也是执行机制。从JDK5开始，把工作单元与执行机制分离开来。工作单元包括Runnable和Callable，而执行机制由Executor框架提供。

### 两级调度模型

在上层，Java多线程程序通常把应用分解为若干个任务，然后使用用户级的调度器(Executor框架)将这些任务映射为固定数量的线程；在底层，操作系统内核将这些线程映射到硬件处理器上。

应用程序通过Executor框架控制上层的调度；而下层的调度由操作系统内核控制，下层的调度不受应用程序的控制。

<div align="center"> 

![](../../assets/cs-note/java-concurrent/任务的两级调度模型.png ':size=500')
</div>

### 框架结构

Executor框架主要由3大部分组成如下
- 任务(Runnable / Callable)：  
  执行任务需要实现的 Runnable 接口 或 Callable接口。Runnable 接口或 Callable 接口 实现类都可以被 ThreadPoolExecutor 或 ScheduledThreadPoolExecutor 执行。
- 任务的执行(Executor)  
  包括任务执行机制的核心接口Executor，以及继承自Executor的ExecutorService接口。Executor框架有两个关键类实现了ExecutorService接口(**ThreadPoolExecutor** 和 **ScheduledThreadPoolExecutor**)  
  > 注意： 通过查看 ScheduledThreadPoolExecutor 源代码我们发现 ScheduledThreadPoolExecutor 实际上是继承了 ThreadPoolExecutor 并实现了 ScheduledExecutorService ，而 ScheduledExecutorService 又实现了 ExecutorService，正如我们下面给出的类关系图显示的一样。 

<div align="center"> 

![](../../assets/cs-note/java-concurrent/任务的执行相关接口.png ':size=500')
</div> 

- 异步计算的结果(Future)  
  Future 接口以及 Future 接口的实现类 FutureTask 类都可以代表异步计算的结果。  
  当我们把 Runnable接口 或 Callable 接口 的实现类提交给 ThreadPoolExecutor 或 ScheduledThreadPoolExecutor 执行。(调用 submit() 方法时会返回一个 FutureTask 对象)
  
### 框架使用

<div align="center"> 

![](../../assets/cs-note/java-concurrent/框架使用示意图.png ':size=500')
</div>

1. 主线程首先要创建实现 Runnable 或者 Callable 接口的任务对象。
2. 把创建完成的实现 Runnable/Callable接口的 对象直接交给 ExecutorService 执行: `ExecutorService.execute(Runnable command))`或者也可以把 Runnable 对象或Callable 对象提交给 ExecutorService 执行 `ExecutorService.submit(Runnable task)`或 `ExecutorService.submit(Callable <T> task))`。
3. 如果执行 ExecutorService.submit(…)，ExecutorService 将返回一个实现 Future 接口的对象(我们刚刚也提到过了执行 execute() 方法和 submit() 方法的区别，submit()会返回一个 FutureTask 对象)。由于 FutureTask 实现了 Runnable，我们也可以创建 FutureTask，然后直接交给 ExecutorService 执行。
4. 最后，主线程可以执行 FutureTask.get() 方法来等待任务执行完成。主线程也可以执行 FutureTask.cancel(boolean mayInterruptIfRunning)来取消此任务的执行。

### Executor框架的成员

#### ThreadPoolExecutor

ThreadPoolExecutor通常使用工厂类Executors来创建。Executors可以创建3种类型的ThreadPoolExecutor：  
- FixedThreadPool 被称为可重用固定线程数的线程池,适用于为了满足资源管理的需求，而需要限制当前线程数量的应用场景，它适用于负载比较重的服务器
- SingleThreadExecutor 是只有一个线程的线程池,适用于需要保证顺序地执行各个任务；并且在任意时间点，不会有多个线程是活动的应用场景
- CachedThreadPool: 是一个会根据需要创建新线程的线程池,是大小无界的线程池，适用于执行很多的短期异步任务的小程序，或者是负载较轻的服务器。

#### ScheduledThreadPoolExecutor

ScheduledThreadPoolExecutor通常使用工厂类Executors来创建。Executors可以创建2种类型的ScheduledThreadPoolExecutor，如下:
- ScheduledThreadPoolExecutor。包含若干个线程的ScheduledThreadPoolExecutor
- SingleThreadScheduledExecutor。只包含一个线程的ScheduledThreadPoolExecutor

#### Future接口

Future接口和实现Future接口的FutureTask类用来表示异步计算的结果。当我们把Runnable接口或Callable接口的实现类提交(submit)给ThreadPoolExecutor或ScheduledThreadPoolExecutor时，ThreadPoolExecutor或ScheduledThreadPoolExecutor会向我们返回一个FutureTask对象。

#### Runnable接口和Callable接口

Runnable接口和Callable接口的实现类，都可以被ThreadPoolExecutor或ScheduledThreadPoolExecutor执行。它们之间的区别是Runnable不会返回结果，而Callable可以返回结果

**比较**
- Runnable自 Java 1.0 以来一直存在，但Callable仅在 Java 1.5 中引入,目的就是为了来处理Runnable不支持的用例。Runnable 接口不会返回结果或抛出检查异常，但是Callable 接口可以。所以，如果任务不需要返回结果或抛出异常推荐使用 Runnable 接口，这样代码看起来会更加简洁。

### ThreadPoolExecutor详解

```java
    /**
     * 用给定的初始参数创建一个新的ThreadPoolExecutor。
     */
    public ThreadPoolExecutor(int corePoolSize,//线程池的核心线程数量
                              int maximumPoolSize,//线程池的最大线程数
                              long keepAliveTime,//当线程数大于核心线程数时，多余的空闲线程存活的最长时间
                              TimeUnit unit,//时间单位
                              BlockingQueue<Runnable> workQueue,//任务队列，用来储存等待执行任务的队列
                              ThreadFactory threadFactory,//线程工厂，用来创建线程，一般默认即可
                              RejectedExecutionHandler handler//拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
                               ) {
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
```
ThreadPoolExecutor 3 个最重要的参数：
- corePoolSize : 核心线程数线程数定义了最小可以同时运行的线程数量。
- maximumPoolSize : 当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
- workQueue: 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，信任就会被存放在队列中。

ThreadPoolExecutor其他常见参数:
- keepAliveTime:当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
- unit : keepAliveTime 参数的时间单位。
- threadFactory :executor 创建新线程的时候会用到。
- handler :饱和策略。关于饱和策略下面单独介绍一下。

线程池中各个参数的相互关系

<div align="center"> 

![](../../assets/cs-note/java-concurrent/线程池各个参数的关系.png ':size=500')
</div>

ThreadPoolExecutor 饱和策略定义:

如果当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任时，ThreadPoolTaskExecutor 定义一些策略:
- ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
- ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务。您不会任务请求。但是这种策略会降低对于新任务提交速度，影响程序的整体性能。另外，这个策略喜欢增加队列容量。如果您的应用程序可以承受此延迟并且你不能任务丢弃任何一个任务请求的话，你可以选择这个策略。
- ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
- ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。

> Spring 通过 ThreadPoolTaskExecutor 或者我们直接通过 ThreadPoolExecutor 的构造函数创建线程池的时候，当我们不指定 RejectedExecutionHandler 饱和策略的话来配置线程池的时候默认使用的是 ThreadPoolExecutor.AbortPolicy。在默认情况下，ThreadPoolExecutor 将抛出 RejectedExecutionException 来拒绝新来的任务 ，这代表你将丢失对这个任务的处理。 对于可伸缩的应用程序，建议使用 ThreadPoolExecutor.CallerRunsPolicy。当最大池被填满时，此策略为我们提供可伸缩队列。(这个直接查看 ThreadPoolExecutor 的构造函数源码就可以看出，比较简单的原因，这里就不贴代码了。)

在《阿里巴巴 Java 开发手册》“并发处理”这一章节，明确指出线程资源必须通过线程池提供，不允许在应用中自行显示创建线程。

> 使用线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源开销，解决资源不足的问题。如果不使用线程池，有可能会造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。

另外《阿里巴巴 Java 开发手册》中强制线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 构造函数的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险

> Executors 返回线程池对象的弊端如下：
- FixedThreadPool 和 SingleThreadExecutor ： 允许请求的队列长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致 OOM。
- CachedThreadPool 和 ScheduledThreadPool ： 允许创建的线程数量为 Integer.MAX_VALUE ，可能会创建大量线程，从而导致 OOM。

#### FixedThreadPool

```java
    /**
     * 创建一个可重用固定数量线程的线程池
     */
    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
    }
```

可以看出新创建的 FixedThreadPool 的 corePoolSize 和 maximumPoolSize 都被设置为 nThreads，这个 nThreads 参数是使用的时传递的。

FixedThreadPool 的 execute() 方法运行示意图

<div align="center"> 

![](../../assets/cs-note/java-concurrent/FixedThreadPool运行示意.png ':size=500')
</div>

1. 如果当前运行的线程数小于 corePoolSize， 如果再来新任务的话，就创建新的线程来执行任务；
2. 当前运行的线程数等于 corePoolSize 后， 如果再来新任务的话，会将任务加入 LinkedBlockingQueue；
3. 线程池中的线程执行完手头的任务后，会在循环中反复从 LinkedBlockingQueue 中获取任务来执行；

**不推荐使用FixedThreadPool**

FixedThreadPool 使用无界队列 LinkedBlockingQueue(队列的容量为 Intger.MAX_VALUE)作为线程池的工作队列会对线程池带来如下影响 ：
1. 当线程池中的线程数达到 corePoolSize 后，新任务将在无界队列中等待，因此线程池中的线程数不会超过 corePoolSize；
2. 由于使用无界队列时 maximumPoolSize 将是一个无效参数，因为不可能存在任务队列满的情况。所以，通过创建 FixedThreadPool的源码可以看出创建的 FixedThreadPool 的 corePoolSize 和 maximumPoolSize 被设置为同一个值。
3. 由于 1 和 2，使用无界队列时 keepAliveTime 将是一个无效参数；
4. 运行中的 FixedThreadPool(未执行 shutdown()或 shutdownNow())不会拒绝任务，在任务比较多的时候会导致 OOM(内存溢出)。


#### SingleThreadExecutor

```java
    /**
     *返回只有一个线程的线程池
     */
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
    }
   public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }
```
可以看出新创建的 SingleThreadExecutor 的 corePoolSize 和 maximumPoolSize 都被设置为 1.其他参数和 FixedThreadPool 相同。

<div align="center"> 

![](../../assets/cs-note/java-concurrent/SingleThreadExecutor运行示意.png ':size=500')
</div>

1. 如果当前运行的线程数少于 corePoolSize，则创建一个新的线程执行任务；
2. 当前线程池中有一个运行的线程后，将任务加入 LinkedBlockingQueue
3. 线程执行完当前的任务后，会在循环中反复从LinkedBlockingQueue 中获取任务来执行；

**不推荐使用 SingleThreadExecutor**

SingleThreadExecutor 使用无界队列 LinkedBlockingQueue 作为线程池的工作队列(队列的容量为 Intger.MAX_VALUE)。SingleThreadExecutor 使用无界队列作为线程池的工作队列会对线程池带来的影响与 FixedThreadPool 相同。说简单点就是可能会导致 OOM，

#### CachedThreadPool

```java
    /**
     * 创建一个线程池，根据需要创建新线程，但会在先前构建的线程可用时重用它。
     */
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>(),
                                      threadFactory);
    }
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
```
CachedThreadPool 的corePoolSize 被设置为空(0)，maximumPoolSize被设置为 Integer.MAX.VALUE，即它是无界的，这也就意味着如果主线程提交任务的速度高于 maximumPool 中线程处理任务的速度时，CachedThreadPool 会不断创建新的线程。极端情况下，这样会导致耗尽 cpu 和内存资源。

<div align="center"> 

![](../../assets/cs-note/java-concurrent/CachedThreadPool运行示意.png ':size=500')
</div>

1. 首先执行 SynchronousQueue.offer(Runnable task) 提交任务到任务队列。如果当前 maximumPool 中有闲线程正在执行 SynchronousQueue.poll(keepAliveTime,TimeUnit.NANOSECONDS)，那么主线程执行 offer 操作与空闲线程执行的 poll 操作配对成功，主线程把任务交给空闲线程执行，execute()方法执行完成，否则执行下面的步骤 2；
2. 当初始 maximumPool 为空，或者 maximumPool 中没有空闲线程时，将没有线程执行 SynchronousQueue.poll(keepAliveTime,TimeUnit.NANOSECONDS)。这种情况下，步骤 1 将失败，此时 CachedThreadPool 会创建新线程执行任务，execute 方法执行完成；

### ScheduledThreadPoolExecutor详解

ScheduledThreadPoolExecutor 使用的任务队列 DelayQueue 封装了一个 PriorityQueue，PriorityQueue 会对队列中的任务进行排序，执行所需时间短的放在前面先被执行(ScheduledFutureTask 的 time 变量小的先执行)，如果执行所需时间相同则先提交的任务将被先执行(ScheduledFutureTask 的 squenceNumber 变量小的先执行)。

ScheduledThreadPoolExecutor 和 Timer 的比较：
- Timer 对系统时钟的变化敏感，ScheduledThreadPoolExecutor不是；
- Timer 只有一个执行线程，因此长时间运行的任务可以延迟其他任务。 ScheduledThreadPoolExecutor 可以配置任意数量的线程。 此外，如果你想(通过提供 ThreadFactory)，你可以完全控制创建的线程;
- 在TimerTask 中抛出的运行时异常会杀死一个线程，从而导致 Timer 死机:
  - ( ...即计划任务将不再运行。ScheduledThreadExecutor 不仅捕获运行时异常，还允许您在需要时处理它们(通过重写 afterExecute 方法ThreadPoolExecutor)。抛出异常的任务将被取消，但其他任务将继续运行。

综上，在 JDK1.5 之后，你没有理由再使用 Timer 进行任务调度了。

> 备注： Quartz 是一个由 java 编写的任务调度库，由 OpenSymphony 组织开源出来。在实际项目开发中使用 Quartz 的还是居多，比较推荐使用 Quartz。因为 Quartz 理论上能够同时对上万个任务进行调度，拥有丰富的功能特性，包括任务调度、任务持久化、可集群化、插件等等。

<div align="center"> 

![](../../assets/cs-note/java-concurrent/ScheduledThreadPoolExecutor运行示意.png ':size=500')
</div>

**ScheduledThreadPoolExecutor 的执行主要分为两大部分：**
1. 当调用 ScheduledThreadPoolExecutor 的 scheduleAtFixedRate() 方法或者scheduleWirhFixedDelay() 方法时，会向 ScheduledThreadPoolExecutor 的 DelayQueue 添加一个实现了 RunnableScheduledFuture 接口的 ScheduledFutureTask 。
2. 线程池中的线程从 DelayQueue 中获取 ScheduledFutureTask，然后执行任务。

ScheduledThreadPoolExecutor 为了实现周期性的执行任务，对 ThreadPoolExecutor做了如下修改：
- 使用 DelayQueue 作为任务队列；
- 获取任务的方不同
- 执行周期任务后，增加了额外的处理

**ScheduledThreadPoolExecutor执行周期任务的步骤**

<div align="center"> 

![](../../assets/cs-note/java-concurrent/ScheduledThreadPoolExecutor执行周期任务运行示意.png ':size=500')
</div>

1. 线程 1 从 DelayQueue 中获取已到期的 ScheduledFutureTask(DelayQueue.take())。到期任务是指 ScheduledFutureTask的 time 大于等于当前系统的时间；
2. 线程 1 执行这个 ScheduledFutureTask；
3. 线程 1 修改 ScheduledFutureTask 的 time 变量为下次将要被执行的时间；
4. 线程 1 把这个修改 time 之后的 ScheduledFutureTask 放回 DelayQueue 中(DelayQueue.add())。

### FutureTask详解

FutureTask除了实现Future接口外，还实现了Runnable接口。因此，FutureTask可以交给Executor执行，也可以由调用线程直接执行(FutureTask.run())。根据FutureTask.run()方法被执行的时机，FutureTask可以处于下面3种状态：
1. 未启动。FutureTask.run()方法还没有被执行之前，FutureTask处于未启动状态。当创建一个FutureTask，且没有执行FutureTask.run()方法之前，这个FutureTask处于未启动状态。
2. 已启动。FutureTask.run()方法被执行的过程中，FutureTask处于已启动状态。
3. 已完成。FutureTask.run()方法执行完后正常结束，或被取消(FutureTask.cancel(…))，或执行FutureTask.run()方法时抛出异常而异常结束，FutureTask处于已完成状态

FutureTask的状态迁移的示意:

<div align="center"> 

![](../../assets/cs-note/java-concurrent/FutureTask的状态迁移示意图.png ':size=500')
</div>

当FutureTask处于未启动或已启动状态时，执行FutureTask.get()方法将导致调用线程阻塞；当FutureTask处于已完成状态时，执行FutureTask.get()方法将导致调用线程立即返回结果或抛出异常。

当FutureTask处于未启动状态时，执行FutureTask.cancel()方法将导致此任务永远不会被执行；当FutureTask处于已启动状态时，执行FutureTask.cancel(true)方法将以中断执行此任务线程的方式来试图停止任务；当FutureTask处于已启动状态时，执行FutureTask.cancel(false)方法将不会对正在执行此任务的线程产生影响(让正在执行的任务运行完成)；当FutureTask处于已完成状态时，执行FutureTask.cancel(…)方法将返回false。

**FutureTask 的使用**

可以把FutureTask交给Executor执行；也可以通过ExecutorService.submit(…)方法返回一个FutureTask，然后执行FutureTask.get()方法或FutureTask.cancel(…)方法。除此以外，还可以单独使用FutureTask。

**FutureTask 的实现**

FutureTask的实现基于AbstractQueuedSynchronizer(以下简称为AQS)。

基于“复合优先于继承”的原则，FutureTask声明了一个内部私有的继承于AQS的子类Sync，对FutureTask所有公有方法的调用都会委托给这个内部子类。

AQS被作为“模板方法模式”的基础类提供给FutureTask的内部子类Sync，这个内部子类只需要实现状态检查和状态更新的方法即可，这些方法将控制FutureTask的获取和释放操作。具体来说，Sync实现了AQS的tryAcquireShared(int)方法和tryReleaseShared(int)方法，Sync通过这两个方法来检查和更新同步状态

<div align="center"> 

![](../../assets/cs-note/java-concurrent/FutureTask的设计示意图.png ':size=500')
</div>

FutureTask.get()方法会调用AQS.acquireSharedInterruptibly(int arg)方法，这个方法的执行过程如下。
1. 调用AQS.acquireSharedInterruptibly(int arg)方法，这个方法首先会回调在子类Sync中实现的tryAcquireShared()方法来判断acquire操作是否可以成功。acquire操作可以成功的条件为：state为执行完成状态RAN或已取消状态CANCELLED，且runner不为null。
2. 如果成功则get()方法立即返回。如果失败则到线程等待队列中去等待其他线程执行release操作。
3. 当其他线程执行release操作(比如FutureTask.run()或FutureTask.cancel(…))唤醒当前线程后，当前线程再次执行tryAcquireShared()将返回正值1，当前线程将离开线程等待队列并唤醒它的后继线程(这里会产生级联唤醒的效果，后面会介绍)。
4. 最后返回计算的结果或抛出异常。

FutureTask.run()的执行过程如下。
1. 执行在构造函数中指定的任务(Callable.call())。
2. 以原子方式来更新同步状态(调用AQS.compareAndSetState(int expect，int update)，设置state为执行完成状态RAN)。如果这个原子操作成功，就设置代表计算结果的变量result的值为Callable.call()的返回值，然后调用AQS.releaseShared(int arg)。
3. AQS.releaseShared(int arg)首先会回调在子类Sync中实现的tryReleaseShared(arg)来执行release操作(设置运行任务的线程runner为null，然会返回true)；AQS.releaseShared(int arg)，然后唤醒线程等待队列中的第一个线程。
4. 调用FutureTask.done()。

当执行FutureTask.get()方法时，如果FutureTask不是处于执行完成状态RAN或已取消状态CANCELLED，当前执行线程将到AQS的线程等待队列中等待(见下图的线程A、B、C和D)。当某个线程执行FutureTask.run()方法或FutureTask.cancel(...)方法时，会唤醒线程等待队列的第一个线程(见图所示的线程E唤醒线程A)

<div align="center"> 

![](../../assets/cs-note/java-concurrent/FutureTask的级联唤醒示意图.png ':size=500')
</div>

假设开始时FutureTask处于未启动状态或已启动状态，等待队列中已经有3个线程(A、B和C)在等待。此时，线程D执行get()方法将导致线程D也到等待队列中去等待。

当线程E执行run()方法时，会唤醒队列中的第一个线程A。线程A被唤醒后，首先把自己从队列中删除，然后唤醒它的后继线程B，最后线程A从get()方法返回。线程B、C和D重复A线程的处理流程。最终，在队列中等待的所有线程都被级联唤醒并从get()方法返回

## Fork/Join框架

Fork/Join框架是Java 7提供的一个用于并行执行任务的框架，是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。

<div align="center"> 

![](../../assets/cs-note/java-concurrent/Fork-Join的运行流程图.png ':size=500')
</div>

**工作窃取(work-stealing)算法**：假如我们需要做一个比较大的任务，我们可以把这个任务分割为若干互不依赖的子任务，为了减少线程间的竞争，于是把这些子任务分别放到不同的队列里，并为每个队列创建一个单独的线程来执行队列里的任务，线程和队列一一对应，比如A线程负责处理A队列里的任务。但是有的线程会先把自己队列里的任务干完，而其他线程对应的队列里还有任务等待处理。干完活的线程与其等着，不如去帮其他线程干活，于是它就去其他线程的队列里窃取一个任务来执行。而在这时它们会访问同一个队列，所以为了减少窃取任务线程和被窃取任务线程之间的竞争，通常会使用双端队列，被窃取任务线程永远从双端队列的头部拿任务执行，而窃取任务的线程永远从双端队列的尾部拿任务执行。
- 工作窃取算法的优点是充分利用线程进行并行计算，并减少了线程间的竞争，
- 缺点是在某些情况下还是存在竞争，比如双端队列里只有一个任务时。并且消耗了更多的系统资源，比如创建多个线程和多个双端队列。

### Fork/Join框架的设计

- 步骤1 分割任务。首先我们需要有一个fork类来把大任务分割成子任务，有可能子任务还是很大，所以还需要不停地分割，直到分割出的子任务足够小。
- 步骤2 执行任务并合并结果。分割的子任务分别放在双端队列里，然后几个启动线程分别从双端队列里获取任务执行。子任务执行完的结果都统一放在一个队列里，启动一个线程从队列里拿数据，然后合并这些数据。

Fork/Join使用两个类来完成以上两件事情
- ForkJoinTask：我们要使用ForkJoin框架，必须首先创建一个ForkJoin任务。它提供在任务中执行fork()和join()操作的机制，通常情况下我们不需要直接继承ForkJoinTask类，而只需要继承它的子类，Fork/Join框架提供了以下两个子类：
  - RecursiveAction：用于没有返回结果的任务。
  - RecursiveTask ：用于有返回结果的任务。
- ForkJoinPool ：ForkJoinTask需要通过ForkJoinPool来执行，任务分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部。当一个工作线程的队列里暂时没有任务时，它会随机从其他工作线程的队列的尾部获取一个任务。



### Fork/Join框架的使用

ForkJoinTask与一般任务的主要区别在于它需要实现compute方法，在这个方法里，首先需要判断任务是否足够小，如果足够小就直接执行任务。如果不足够小，就必须分割成两个子任务，每个子任务在调用fork方法时，又会进入compute方法，看看当前子任务是否需要继续分割成子任务，如果不需要继续分割，则执行当前子任务并返回结果。使用join方法会等待子任务执行完并得到其结果。

ForkJoinTask在执行的时候可能会抛出异常，但是我们没办法在主线程里直接捕获异常，所以ForkJoinTask提供了isCompletedAbnormally()方法来检查任务是否一件抛出异常或已经被取消了，并且可以通过ForkJoinTask的getException方法获取异常。其中，getException方法返回Throwable对象，如果任务被取消了则返回CancellationException，如果任务没有完成或者没有抛出异常则返回null。

### Fork/Join框架的实现原理

ForkJoinPool由ForkJoinTask数组和ForkJoinWorkerThread数组组成，ForkJoinTask数组负责将存放程序提交给ForkJoinPool的任务，而ForkJoinWorkerThread数组负责执行这些任务

1. ForkJoinTask的**fork**方法实现原理  
当我们调用ForkJoinTask的fork方法时，程序会调用ForkJoinWorkerThread的pushTask方法异步地执行这个任务，然后立即返回结果。
```java
    public final ForkJoinTask<V> fork() {
        ((ForkJoinWorkerThread) Thread.currentThread())
            .pushTask(this);
        return this;
    }
```
pushTask方法把当前任务存放在ForkJoinTask数组队列里。然后再调用ForkJoinPool的signalWork()方法唤醒或创建一个工作线程来执行任务
```java
    final void pushTask(ForkJoinTask<> t) {
        ForkJoinTask<>[] q; int s, m;
        if ((q = queue) != null) { // ignore if queue removed
            long u = (((s = queueTop) & (m = q.length - 1)) << ASHIFT) + ABASE;
            UNSAFE.putOrderedObject(q, u, t);
            queueTop = s + 1; // or use putOrderedInt
            if ((s -= queueBase) <= 2)
                pool.signalWork();
            else if (s == m)
                growQueue();
        }
    }
```

2. ForkJoinTask的**join**方法实现原理  
Join方法的主要作用是阻塞当前线程并等待获取结果
```java
    public final V join() {
        if (doJoin() != NORMAL)
            return reportResult();
        else
            return getRawResult();
    }

    private V reportResult() {
        int s;
        Throwable ex;
        if ((s = status) == CANCELLED)
            throw new CancellationException();
        if (s == EXCEPTIONAL && (ex = getThrowableException()) != null)
            UNSAFE.throwException(ex);
        return getRawResult();
    }
```
首先，它调用了doJoin()方法，通过doJoin()方法得到当前任务的状态来判断返回什么结果，任务状态有4种：已完成(NORMAL)、被取消(CANCELLED)、信号(SIGNAL)和出现异常(EXCEPTIONAL)。
   - 如果任务状态是已完成，则直接返回任务结果。
   - 如果任务状态是被取消，则直接抛出CancellationException。
   - 如果任务状态是抛出异常，则直接抛出对应的异常。
```java
    private int doJoin() {
        Thread t;
        ForkJoinWorkerThread w;
        int s;
        boolean completed;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
            if ((s = status) < 0)
                return s;
            if ((w = (ForkJoinWorkerThread) t).unpushTask(this)) {
                try {
                    completed = exec();
                } catch (Throwable rex) {
                    return setExceptionalCompletion(rex);
                }
                if (completed)
                    return setCompletion(NORMAL);
            }
            return w.joinTask(this);
        } else
            return externalAwaitDone();
    }
```
在doJoin()方法里，首先通过查看任务的状态，看任务是否已经执行完成，如果执行完成，则直接返回任务状态；如果没有执行完，则从任务数组里取出任务并执行。如果任务顺利执行完成，则设置任务状态为NORMAL，如果出现异常，则记录异常，并将任务状态设置为EXCEPTIONAL。

# 参考资料

- BruceEckel. Java 编程思想: 第 4 版 [M]. 机械工业出版社, 2007.
- 周志明. 深入理解 Java 虚拟机 [M]. 机械工业出版社, 2011.
- [Threads and Locks](https://docs.oracle.com/javase/specs/jvms/se6/html/Threads.doc.html)
- [线程通信](http://ifeve.com/thread-signaling/#missed_signal)
- [Java 线程面试题 Top 50](http://www.importnew.com/12773.html)
- [BlockingQueue](http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html)
- [thread state java](https://stackoverflow.com/questions/11265289/thread-state-java)
- [CSC 456 Spring 2012/ch7 MN](http://wiki.expertiza.ncsu.edu/index.php/CSC_456_Spring_2012/ch7_MN)
- [Java - Understanding Happens-before relationship](https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/happens-before.html)
- [6장 Thread Synchronization](https://www.slideshare.net/novathinker/6-thread-synchronization)
- [How is Java's ThreadLocal implemented under the hood?](https://stackoverflow.com/questions/1202444/how-is-javas-threadlocal-implemented-under-the-hood/15653015)
- [Concurrent](https://sites.google.com/site/webdevelopart/21-compile/06-java/javase/concurrent?tmpl=%2Fsystem%2Fapp%2Ftemplates%2Fprint%2F&showPrintDialog=1)
- [JAVA FORK JOIN EXAMPLE](http://www.javacreed.com/java-fork-join-example/ "Java Fork Join Example")
- [聊聊并发(八)——Fork/Join 框架介绍](http://ifeve.com/talk-concurrency-forkjoin/)
- [Eliminating SynchronizationRelated Atomic Operations with Biased Locking and Bulk Rebiasing](http://www.oracle.com/technetwork/java/javase/tech/biasedlocking-oopsla2006-preso-150106.pdf)




