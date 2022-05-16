<!-- GFM-TOC -->
* [Java 8 特性](#java-8-特性)
  * [Java语言](#java语言)
    * [接口的默认方法](#接口的默认方法)
    * [接口静态方法](#接口静态方法)
    * [Lambda表达式](#lambda表达式)
    * [方法和构造函数引用](#方法和构造函数引用)
    * [多重注解](#多重注解)
    * [forEach](#foreach)
  * [Java 官方库](#java-官方库)
    * [Streams](#streams)
    * [Parallel Streams](#parallel-streams)
    * [Optionals](#optionals)
    * [日期相关API(Date API)](#日期相关apidate-api)
    * [Base64](#base64)
  * [JVM](#jvm)
<!-- GFM-TOC -->


# Java 8 特性

## Java语言

### 接口的默认方法

**Default Methods for Interfaces**

Java 8 使用两个新概念扩展了接口的含义：默认方法和静态方法。

默认方法使得开发者可以在不破坏二进制兼容性的前提下，往现存接口中添加新的方法，即不强制那些实现了该接口的类也同时实现这个新加的方法。 

默认方法和抽象方法之间的区别在于抽象方法需要实现，而默认方法不需要。接口提供的默认方法会被接口的实现类继承或者覆写

不管是抽象类还是接口，都可以通过匿名内部类的方式访问。不能通过抽象类或者接口直接创建对象。对于通过匿名内部类方式访问接口，我们可以这样理解：一个内部类实现了接口里的抽象方法并且返回一个内部类对象，之后我们让接口的引用来指向这个对象。

### 接口静态方法

Java 8 带来的另一个有趣的特性是在接口中可以定义静态方法

由于JVM上的默认方法的实现在字节码层面提供了支持，因此效率非常高。默认方法允许在不打破现有继承体系的基础上改进接口。

该特性在官方库中的应用是：给java.util.Collection接口添加新方法，如stream()、parallelStream()、forEach()和removeIf()等等。

尽管默认方法有这么多好处，但在实际开发中应该谨慎使用：在复杂的继承体系中，默认方法可能引起歧义和编译错误。

### Lambda表达式

**Lambda expressions**

传统匿名内部类缺点：代码臃肿，难以阅读

lambda表达式本质上是一段匿名内部类，也可以是一段可以传递的代码；Lambda 表达式将函数当成参数传递给某个方法，或者把代码本身当作数据处理；

Lambda表达式在大多数虚拟机中采用invokeDynamic指令实现，相对于匿名内部类在效率上会更高一些。

#### Lamda 表达式作用域

**Lambda Scopes**

**访问局部变量**

可以直接在 lambda 表达式中访问外部的局部变量，和匿名对象不同的是，这里的变量可以不用声明为final，不过这里的变量必须不可被后面的代码修改（即隐性的具有final的语义）

**访问字段和静态变量**

与局部变量相比，我们对lambda表达式中的实例字段和静态变量都有读写访问权限。 该行为和匿名对象是一致的。

**访问默认接口方法**

可以从包含匿名对象的每个接口实现实例访问该默认方法方法， 这不适用于lambda表达式；无法从 lambda 表达式中访问默认方法

#### Lambda 表达式实现方式 

- 在类编译时，会生成一个私有静态方法+一个内部类。
- 在内部类中实现了函数式接口，在实现接口的方法中，会调用编译器生成的静态方法。
- 在使用lambda表达式的地方，通过传递内部类实例，来调用函数式接口方法。


#### 函数式接口

**Functional Interfaces**

Java 语言设计者们投入了大量精力来思考如何使现有的函数友好地支持Lambda。最终采取的方法是：增加函数式接口的概念。**“函数式接口”是指仅仅只包含一个抽象方法,但是可以有多个非抽象方法(默认方法和静态方法)的接口**。 像这样的接口，可以被隐式转换为lambda表达式。

- 接口中只能有一个抽象接口方法
- 可以有静态方法和默认方法
- 建议在接口上使用@FunctionalInterface 注解进行声明，这样的话，编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的
- 默认方法可以被覆写

大部分函数式接口都不用我们自己写，Java8都给我们实现好了，这些接口都在java.util.function包里

#### 内置函数式接口

**Built-in Functional Interfaces**

Java 8 API包含许多内置函数式接口。 其中一些接口在老版本的 Java 中是比较常见的比如： Comparator 或Runnable，这些接口都增加了@FunctionalInterface注解以便能用在 lambda 表达式上。

但是 Java 8 API 同样还提供了很多全新的函数式接口来让你的编程工作更加方便，有一些接口是来自 Google Guava 库里的。

- `Function<T,R>` T 作为输入，返回的 R 作为输出
- `Predicate<T>` T 作为输入 ，返回 boolean 值的输出
- `Consumer<T>` T 作为输入 ，没有输出
- `Supplier<R>` 没有输入 , R 作为输出
- `BinaryOperator<T>` 两个 T 作为输入 ，T 同样是输出
- `UnaryOperator<T>` 是 Function 的变种 ，输入输出者是 T

##### Predicates

Predicate 接口是只有一个参数的返回布尔类型值的 断言型 接口。该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）

```java
package java.util.function;
import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    // 该方法是接受一个传入类型,返回一个布尔值.此方法应用于判断.
    boolean test(T t);

    //and方法与关系型运算符"&&"相似，两边都成立才返回true
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    // 与关系运算符"!"相似，对判断进行取反
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    //or方法与关系型运算符"||"相似，两边只要有一个成立就返回true
    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    // 该方法接收一个Object对象,返回一个Predicate类型.此方法用于判断第一个test的方法与第二个test方法相同(equal).
    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
            ? Objects::isNull
            : object -> targetRef.equals(object);
    }
}
```

##### Functions

Function 接口接受一个参数并生成结果。默认方法可用于将多个函数链接在一起（compose, andThen）

```java 
package java.util.function;
import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {

    //将Function对象应用到输入的参数上，然后返回计算结果。
    R apply(T t);

    //将两个Function整合，并返回一个能够执行两个Function对象功能的Function对象。
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    //
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

##### Suppliers

Supplier 接口产生给定泛型类型的结果。 与 Function 接口不同，Supplier 接口不接受参数。

##### Consumers

Consumer 接口表示要对单个输入参数执行的操作

##### Comparators

Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法：

```java
    Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

    Person p1 = new Person("John", "Doe");
    Person p2 = new Person("Alice", "Wonderland");

    comparator.compare(p1, p2);             // > 0
    comparator.reversed().compare(p1, p2);  // < 0
```


### 方法和构造函数引用

**Method and Constructor References**

通常与Lambda表达式联合使用，方法引用使得可以直接引用已有Java类或对象的方法

Java 8允许您通过::关键字传递方法或构造函数的引用，

1. 构造器引用，语法是`Class::new`，或者更一般的形式：`Class<T>::new`
2. 静态方法引用，语法是`Class::static_method`
3. 某个类的成员方法的引用，语法是`Class::method`
4. 某个实例对象的成员方法的引用，语法是`instance::method` 


### 多重注解

在Java 5中使用注解有一个限制，即相同的注解在同一位置只能声明一次。Java 8引入重复注解，这样相同的注解在同一地方也可以声明多次。重复注解机制本身需要用@Repeatable注解。Java 8在编译器层做了优化，相同注解会以集合的方式保存，因此底层的原理并没有变化。

另外，反射API提供了一个新的方法：getAnnotationsByType()，可以返回某个类型的重复注解

### forEach

Collection 接口实现了 Iterable 接口，而 Iterable 接口在 Java 8开始具有一个新的 API：

```java
    public interface Collection<E> extends Iterable<E>

    void forEach(Consumer<? super T> action)//对 Iterable的每个元素执行给定的操作，直到所有元素都被处理或动作引发异常。
```

使用forEach，我们可以迭代一个集合并对每个元素执行给定的操作，就像任何其他迭代器一样。

迭代和打印字符串集合的for循环版本和forEach版本
```java
    for (String name : names) {
        System.out.println(name);
    }

    names.forEach(name -> {
        System.out.println(name);
    });
```
#### forEach的方法使用

##### 匿名类

使用 forEach迭代集合并对每个元素执行特定操作。要执行的操作包含在实现Consumer接口的类中，并作为参数传递给forEach 。

所述消费者接口是一个功能接口(具有单个抽象方法的接口）。它接受输入并且不返回任何结果。

```java
    Consumer<String> printConsumer = new Consumer<String>() {
        public void accept(String name) {
            System.out.println(name);
        };
    };
    //可以作为参数传递给forEach：
    names.forEach(printConsumer);
```

##### lambda表达式

由于 Consumer 接口属于函数式接口，可以通过以下形式在Lambda中表达它
```java
    names.forEach(name -> System.out.println(name));
```

##### 方法引用

以使用方法引用语法而不是普通的Lambda语法，其中已存在一个方法来对类执行操作
```java
    names.forEach(System.out::println);
```

#### forEach在集合中的使用

##### 迭代集合

任何类型Collection的可迭代 - 列表，集合，队列 等都具有使用forEach的相同语法。

```java
    List<String> names = Arrays.asList("Larry", "Steve", "James");
    names.forEach(System.out::println);
```

##### 迭代Map

1. **使用Map的forEach**

Map没有实现Iterable接口，但它提供了自己的**forEach 变体**，它接受**BiConsumer**。

```java
    Map<Integer, String> namesMap = new HashMap<>();
    namesMap.put(1, "Larry");
    namesMap.put(2, "Steve");
    namesMap.put(3, "James");
    namesMap.forEach((key, value) -> System.out.println(key + " " + value));
```

2. 通过迭代entrySet

```java
    namesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
```

##### 迭代Map

## Java 官方库

### Streams

Stream API是把真正的函数式编程风格引入到Java中。其实简单来说可以把Stream理解为MapReduce，当然Google的MapReduce的灵感也是来自函数式编程。其实是一连串支持连续、并行聚集操作的元素。

java.util.Stream 表示能应用在一组元素上一次执行的操作序列。Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回一个新的 Stream(这样可以将多个操作依次串起来)，只是把要做的操作记录起来而已，并不会真的执行，最终操作才会真的遍历列表并执行所有操作。Stream 的创建需要指定一个数据源，比如java.util.Collection 的子类，List 或者 Set， Map 不支持。Stream 的操作可以串行执行或者并行执行。

Java 8 扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream。

**Maps**

Map 类型不支持 streams，不过Map提供了一些新的有用的方法来处理一些日常任务。Map接口本身没有可用的 stream（）方法，但是你可以在键，值上创建专门的流或者通过 map.keySet().stream(),map.values().stream()和map.entrySet().stream()。

此外,Maps 支持各种新的和有用的方法来执行常见任务

- `putIfAbsent` 阻止我们在null检查时写入额外的代码; 
- `forEach` 接受一个 BiConsumer 来对 map 中的每个元素操作。
- `computeIfPresent`
- `getOrDefault`
- `merge`
- ...

Stream API 简化了集合的操作，并扩展了集合的分组，求和，mapReduce，flatMap ，排序等功能。



#### Filter(过滤)

过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。

```java
    List<String> stringList = new ArrayList<>();
    stringList.add("ddd2");
    stringList.add("aaa2");
    stringList.add("bbb1");
    stringList.add("aaa1");
    stringList.add("bbb3");
    stringList.add("ccc");
    stringList.add("bbb2");
    stringList.add("ddd1");
```

```java
    stringList
            .stream().filter((s) -> s.startsWith("a"))
            .forEach(System.out::println);//aaa2 aaa1
```
forEach 是为 Lambda 而设计的，保持了最紧凑的风格。而且 Lambda 表达式本身是可以重用的，非常方便

#### Sorted(排序)

排序是一个 中间操作，返回的是排序好后的 Stream。如果你不指定一个自定义的 Comparator 则会使用默认排序。

```java
    // 测试 Sort (排序)
    stringList
            .stream().sorted().filter((s) -> s.startsWith("a"))
            .forEach(System.out::println);// aaa1 aaa2
```
**注意**：
排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的

#### Map(映射)

中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。

下面的示例展示了将字符串转换为大写字符串。你也可以通过map来将对象转换成其他类型，map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
```java
    // 测试 Map 操作
    stringList
        .stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
```

#### Match(匹配)

Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是 最终操作 ，并返回一个 boolean 类型的值。
```java
    // 测试 Match (匹配)操作
    boolean anyStartsWithA =
        stringList
            .stream()
            .anyMatch((s) -> s.startsWith("a"));
    System.out.println(anyStartsWithA);      // true

    boolean allStartsWithA =
        stringList
            .stream()
            .allMatch((s) -> s.startsWith("a"));

    System.out.println(allStartsWithA);      // false

    boolean noneStartsWithZ =
        stringList
            .stream()
            .noneMatch((s) -> s.startsWith("z"));

    System.out.println(noneStartsWithZ);      // true
```

#### Count(计数)

计数是一个 最终操作，返回Stream中元素的个数，返回值类型是 long。
```java
    //测试 Count (计数)操作
    long startsWithB =
        stringList
            .stream()
            .filter((s) -> s.startsWith("b"))
            .count();
    System.out.println(startsWithB);    // 3
```
#### Reduce(规约)
这是一个最终操作 ，允许通过指定的函数来讲stream中的多个元素规约为一个元素，规约后的结果是通过Optional 接口表示的：
```java
    /测试 Reduce (规约)操作
    Optional<String> reduced =
        stringList
            .stream()
            .sorted()
            .reduce((s1, s2) -> s1 + "#" + s2);

    reduced.ifPresent(System.out::println);//aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2
```
这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。例如 Stream 的 sum 就相当于Integer sum = integers.reduce(0, (a, b) -> a+b);也有没有起始值的情况，这时会把 Stream 的前面两个元素组合起来，返回的是 Optional。

### Parallel Streams

Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。

### Optionals

Java 8引入Optional类来防止空指针异常，Optional类最先是由Google的Guava项目引入的。Optional类实际上是个容器：它可以保存类型T的值，或者保存null。使用Optional类我们就不用显式进行空指针检查了。在Java 8之前一般某个函数应该返回非空对象但是有时却什么也没有返回，而在Java 8中，你应该返回 Optional 而不是 null。

### 日期相关API(Date API)

时间和日期的管理一直是最令Java开发者痛苦的问题。java.util.Date和后来的java.util.Calendar一直没有解决这个问题。（甚至令开发者更加迷茫）。因为这些原因，诞生了第三方库Joda-Time，可以替代Java的时间管理API。

Java 8中新的时间和日期管理API深受Joda-Time影响，并吸收了很多Joda-Time的精华。新的java.time包包含了所有关于日期、时间、时区、Instant（跟日期类似但是精确到纳秒）、duration（持续时间）和时钟操作的类。新设计的API认真考虑了这些类的不变性（从java.util.Calendar吸取的教训），如果某个实例需要修改，则返回一个新的对象。

> - jdk1.8中新增了 LocalDate 与 LocalDateTime等类来解决日期处理方法，同时引入了一个新的类DateTimeFormatter 来解决日期格式化问题。
> - 可以使用Instant代替 Date，LocalDateTime代替 Calendar，DateTimeFormatter 代替 SimpleDateFormat。

#### Clock

Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。某一个特定的时间点也可以使用 Instant 类来表示，Instant 类也可以用来创建旧版本的java.util.Date 对象。

```java
    Clock clock = Clock.systemDefaultZone();
    long millis = clock.millis();
    System.out.println(millis);//1552379579043
    Instant instant = clock.instant();
    System.out.println(instant);
    Date legacyDate = Date.from(instant); //2019-03-12T08:46:42.588Z
    System.out.println(legacyDate);//Tue Mar 12 16:32:59 CST 2019
```

#### Timezones(时区)

在新API中时区使用 ZoneId 来表示。时区可以很方便的使用静态方法of来获取到。 抽象类ZoneId（在java.time包中）表示一个区域标识符。 它有一个名为getAvailableZoneIds的静态方法，它返回所有区域标识符。

```java
    //输出所有区域标识符
    System.out.println(ZoneId.getAvailableZoneIds());

    ZoneId zone1 = ZoneId.of("Europe/Berlin");
    ZoneId zone2 = ZoneId.of("Brazil/East");
    System.out.println(zone1.getRules());// ZoneRules[currentStandardOffset=+01:00]
    System.out.println(zone2.getRules());// ZoneRules[currentStandardOffset=-03:00]
```

#### LocalTime(本地时间)

LocalTime 定义了一个没有时区信息的时间，例如 晚上10点或者 17:30:15。下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时和分钟为单位计算两个时间的时间差：
```java
    LocalTime now1 = LocalTime.now(zone1);
    LocalTime now2 = LocalTime.now(zone2);
    System.out.println(now1.isBefore(now2));  // false

    long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
    long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

    System.out.println(hoursBetween);       // -3
    System.out.println(minutesBetween);     // -239
```

LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串.
```java
    LocalTime late = LocalTime.of(23, 59, 59);
    System.out.println(late);       // 23:59:59
    DateTimeFormatter germanFormatter =
        DateTimeFormatter
            .ofLocalizedTime(FormatStyle.SHORT)
            .withLocale(Locale.GERMAN);

    LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
    System.out.println(leetTime);   // 13:37
```

#### LocalDate(本地日期)

LocalDate 表示了一个确切的日期，比如 2014-03-11。该对象值是不可变的，用起来和LocalTime基本一致。下面的例子展示了如何给Date对象加减天/月/年。另外要注意的是这些对象是不可变的，操作返回的总是一个新实例。

#### LocalDateTime(本地日期时间)

LocalDateTime 同时表示了时间和日期，相当于前两节内容合并到一个对象上了。LocalDateTime 和 LocalTime还有 LocalDate 一样，都是不可变的。

### Base64

在Java 8中，Base64编码成为了Java类库的标准。Base64类同时还提供了对URL、MIME友好的编码器与解码器。


## JVM

使用Metaspace（JEP 122）代替持久代（PermGen space）。在JVM参数方面，使用-XX:MetaSpaceSize和-XX:MaxMetaspaceSize代替原来的-XX:PermSize和-XX:MaxPermSize。