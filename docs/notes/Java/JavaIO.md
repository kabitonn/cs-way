<!-- GFM-TOC -->
* [一、概览](#一概览)
  * [分类说明](#分类说明)
    * [操作方式分类结构](#操作方式分类结构)
    * [操作对象分类结构](#操作对象分类结构)
    * [其他类](#其他类)
* [二、磁盘操作](#二磁盘操作)
  * [File](#File)
  * [Path](#Path)
  * [Files](#Files)
* [三、字节操作](#三字节操作)
  * [实现文件复制](#实现文件复制)
  * [装饰者模式](#装饰者模式)
* [四、字符操作](#四字符操作)
  * [编码与解码](#编码与解码)
  * [String 的编码方式](#String-的编码方式)
  * [Reader 与 Writer](#Reader-与-Writer)
  * [实现逐行输出文本文件的内容](#实现逐行输出文本文件的内容)
* [五、对象操作](#五对象操作)
  * [序列化](#序列化)
  * [Serializable](#Serializable)
  * [transient](#transient)
* [六、网络操作](#六网络操作)
  * [InetAddress](#InetAddress)
  * [URL](#URL)
  * [Sockets](#Sockets)
  * [Datagram](#Datagram)
* [七、NIO](#七NIO)
  * [流与块](#流与块)
  * [通道](#通道)
  * [缓冲区](#缓冲区)
    * [缓冲区状态变量](#缓冲区状态变量)
  * [选择器](#选择器)
    * [1. 创建选择器](#1-创建选择器)
    * [2. 将通道注册到选择器上](#2-将通道注册到选择器上)
    * [3. 监听事件](#3-监听事件)
    * [4. 获取到达的事件](#4-获取到达的事件)
    * [5. 事件循环](#5-事件循环)
  * [文件 NIO 实例](#文件-NIO-实例)
  * [套接字 NIO 实例](#套接字-NIO-实例)
  * [其他实例](#其他实例)
  * [Scatter / Gather](#Scatter--Gather)
  * [内存映射文件](#内存映射文件)
* [BIO,NIO,AIO](#BIONIOAIO)
  * [BIO(Blocking I/O)](#BIOBlocking-IO)
  * [NIO(Non-blocking I/O)](#NIONon-blocking-IO)
  * [AIO(Asynchronous I/O)](#AIOAsynchronous-IO)
* [八、参考资料](#八参考资料)
<!-- GFM-TOC -->


# 一、概览

Java 的 I/O 大概可以分成以下几类：

- 磁盘操作：File
- 字节操作：InputStream 和 OutputStream
- 字符操作：Reader 和 Writer
- 对象操作：Serializable
- 网络操作：Socket
- 新的输入/输出：NIO

## 分类说明

IO流的分类：
- 按照流的流向分
  - 输出流：从内存读出到文件。只能进行写操作。
  - 输入流：从文件读入到内存。只能进行读操作。
- 按照操作单元划分
  - 字节流：以字节为单位，每次次读入或读出是8位数据。可以读任何类型数据。
  - 字符流：以字符为单位，每次次读入或读出是16位数据。其只能读取字符类型数据。
- 按照流的角色划分
  - 节点流：直接与数据源相连，读入或读出。
  - 处理流：与节点流一块使用，在节点流的基础上，再套接一层，套接在节点流上的就是处理流。

流的原理浅析:
- java Io流共涉及40多个类，这些类看上去很杂乱，但实际上很有规则，而且彼此之间存在非常紧密的联系， Java Io流的40多个类都是从如下4个抽象类基类中派生出来的。
- InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
- OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。

[Java IO 面试题](https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247484945&amp;idx=1&amp;sn=229be49807e3c2a9621f42c0a6c0aeb6&source=41#wechat_redirect)

### 操作方式分类结构

<div align="center"> 

![](../../assets/cs-note/java-io/IO-操作方式分类.png ':size=800')
</div>

**输入字节流InputStream**：
- ByteArrayInputStream、StringBufferInputStream、FileInputStream 是三种基本的介质流，它们分别从Byte 数组、StringBuffer、和本地文件中读取数据。
- PipedInputStream 是从与其它线程共用的管道中读取数据。PipedInputStream的一个实例要和PipedOutputStream的一个实例共同使用，共同完成管道的读取写入操作。主要用于线程操作。
- DataInputStream： 将基础数据类型读取出来
- ObjectInputStream 和所有 FilterInputStream 的子类都是装饰流(装饰器模式的主角）。

**输出字节流OutputStream**：
- ByteArrayOutputStream、FileOutputStream： 是两种基本的介质流，它们分别向- Byte 数组、和本地文件中写入数据。
- PipedOutputStream 是向与其它线程共用的管道中写入数据。
- DataOutputStream 将基础数据类型写入到文件中
- ObjectOutputStream 和所有 FilterOutputStream 的子类都是装饰流。

**字符输入流Reader**：
- FileReader、CharReader、StringReader 是三种基本的介质流，它们分在本地文件、Char 数组、String中读取数据。
- PipedReader：是从与其它线程共用的管道中读取数据
- BufferedReader ：加缓冲功能，避免频繁读写硬盘
- InputStreamReader： 是一个连接字节流和字符流的桥梁，它将字节流转变为字符流。

**字符输出流Writer**：
- StringWriter:向String 中写入数据。
- CharArrayWriter：实现一个可用作字符输入流的字符缓冲区
- PipedWriter:是向与其它线程共用的管道中写入数据
- BufferedWriter ： 增加缓冲功能，避免频繁读写硬盘。
- PrintWriter 和 PrintStream 将对象的格式表示打印到文本输出流。 极其类似，功能和使用也非常相似
- OutputStreamWriter： 是 OutputStream 到 Writer 转换的桥梁，它的子类FileWriter 其实就是一个实现此功能的具体类

### 操作对象分类结构

<div align="center"> 

![](../../assets/cs-note/java-io/IO-操作对象分类.png ':size=800')
</div>

对**文件**进行操作(节点流）：
- FileInputStream(字节输入流）
- FileOutputStream(字节输出流）
- FileReader(字符输入流）
- FileWriter(字符输出流）

对**管道**进行操作(节点流）：
- PipedInputStream(字节输入流）
- PipedOutStream(字节输出流）
- PipedReader(字符输入流）
- PipedWriter(字符输出流）

PipedInputStream的一个实例要和PipedOutputStream的一个实例共同使用，共同完成管道的读取写入操作。主要用于线程操作。

**字节/字符数组**流(节点流）：
- ByteArrayInputStream
- ByteArrayOutputStream
- CharArrayReader
- CharArrayWriter

除了上述三种是节点流，其他都是处理流，需要跟节点流配合使用。

Buffered缓冲流(处理流）：带缓冲区的处理流，缓冲区的作用的主要目的是：避免每次和硬盘打交道，提高数据访问的效率
- BufferedInputStream
- BufferedOutputStream
- BufferedReader
- BufferedWriter

转化流(处理流）：
- InputStreamReader：把字节转化成字符
- OutputStreamWriter：把字节转化成字符。

基本类型数据流(处理流）：用于操作基本数据类型值
- DataInputStream
- DataOutputStream

打印流(处理流）：一般是打印到控制台，可以进行控制打印的地方
- PrintStream
- PrintWriter

对象流(处理流）：把封装的对象直接输出，而不是一个个在转换成字符串再输出
- ObjectInputStream：对象反序列化
- ObjectOutputStream：对象序列化

合并流(处理流）：
- SequenceInputStream：可以认为是一个工具类，将两个或者多个输入流当成一个输入流依次读取。

### 其他类

**File类**是对文件系统中文件以及文件夹进行封装的对象，可以通过对象的思想来操作文件和文件夹。 File类保存文件或目录的各种元数据信息，包括文件名、文件长度、最后修改时间、是否可读、获取当前文件的路径名，判断指定文件是否存在、获得当前目录中的文件列表，创建、删除文件和目录等方法。

**RandomAccessFile**，该对象并不是流体系中的一员，其封装了字节流，同时还封装了一个缓冲区(字符数组），通过内部的指针来操作字符数组中的数据。 该对象特点：
- 该对象只能操作文件，所以构造函数接收两种类型的参数：a.字符串文件路径；b.File对象
- 该对象既可以对文件进行读操作，也能进行写操作，在进行对象实例化时可指定操作模式(r,rw)

# 二、磁盘操作

Java7中文件IO发生了很大的变化，专门引入了很多新的类来取代原来的基于java.io.File的文件IO操作方式

## File
File 类可以用于表示文件和目录的信息，但是它不表示文件的内容。

递归地列出一个目录下所有文件：

```java
public static void listAllFiles(File dir) {
    if (dir == null || !dir.exists()) {
        return;
    }
    if (dir.isFile()) {
        System.out.println(dir.getName());
        return;
    }
    for (File file : dir.listFiles()) {
        listAllFiles(file);
    }
}
```

从 Java7 开始，可以使用 Paths 和 Files 代替 File。

## Path

1. 创建一个Path
   - 创建Path实例可以通过 Paths工具类 的 get(）方法：
2. File和Path之间的转换，File和URI之间的转换
3. 获取Path的相关信息
4. 移除冗余项：把.和..去除
   - normalize() : 返回一个路径，该路径是冗余名称元素的消除
   - toRealPath() : 融合了toAbsolutePath()方法和normalize()方法

## Files

Java NIO中的Files类(java.nio.file.Files）提供了多种操作文件系统中文件的方法。

java.nio.file.Files类是和java.nio.file.Path相结合使用的

1. 检查给定的Path在文件系统中是否存在：Files.exists() 
2. 创建文件/文件夹
    - Files.createFile()：创建文件
    - Files.createDirectories()：首先创建所有不存在的父目录来创建目录
    - Files.createDirectory()：只是创建目录
3. 删除文件或目录：Files.delete()
4. 把一个文件从一个地址复制到另一个位置:Files.copy()
5. 获取文件属性
6. 遍历一个文件夹：Files.newDirectoryStream()
7. 遍历整个文件目录：Files.walkFileTree()

# 三、字节操作

## 实现文件复制

```java
public static void copyFile(String src, String dist) throws IOException {
    FileInputStream in = new FileInputStream(src);
    FileOutputStream out = new FileOutputStream(dist);

    byte[] buffer = new byte[20 * 1024];
    int cnt;

    // read() 最多读取 buffer.length 个字节
    // 返回的是实际读取的个数
    // 返回 -1 的时候表示读到 eof，即文件尾
    while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
        out.write(buffer, 0, cnt);
    }

    in.close();
    out.close();
}
```

## 装饰者模式

Java I/O 使用了装饰者模式来实现。以 InputStream 为例，

- InputStream 是抽象组件；
- FileInputStream 是 InputStream 的子类，属于具体组件，提供了字节流的输入操作；
- FilterInputStream 属于抽象装饰者，装饰者用于装饰组件，为组件提供额外的功能。例如 BufferedInputStream 为 FileInputStream 提供缓存的功能。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/9709694b-db05-4cce-8d2f-1c8b09f4d921.png" width="650px"> </div><br>

实例化一个具有缓存功能的字节流对象时，只需要在 FileInputStream 对象上再套一层 BufferedInputStream 对象即可。

```java
FileInputStream fileInputStream = new FileInputStream(filePath);
BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
```

DataInputStream 装饰者提供了对更多数据类型进行输入的操作，比如 int、double 等基本类型。

# 四、字符操作

## 编码与解码

编码就是把字符转换为字节，而解码是把字节重新组合成字符。

如果编码和解码过程使用不同的编码方式那么就出现了乱码。

- GBK 编码中，中文字符占 2 个字节，英文字符占 1 个字节；
- UTF-8 编码中，中文字符占 3 个字节，英文字符占 1 个字节；
- UTF-16be 编码中，中文字符和英文字符都占 2 个字节。

UTF-16be 中的 be 指的是 Big Endian，也就是大端。相应地也有 UTF-16le，le 指的是 Little Endian，也就是小端。

Java 的内存编码使用双字节编码 UTF-16be，这不是指 Java 只支持这一种编码方式，而是说 char 这种类型使用 UTF-16be 进行编码。char 类型占 16 位，也就是两个字节，Java 使用这种双字节编码是为了让一个中文或者一个英文都能使用一个 char 来存储。

## String 的编码方式

String 可以看成一个字符序列，可以指定一个编码方式将它编码为字节序列，也可以指定一个编码方式将一个字节序列解码为 String。

```java
String str1 = "中文";
byte[] bytes = str1.getBytes("UTF-8");
String str2 = new String(bytes, "UTF-8");
System.out.println(str2);
```

在调用无参数 getBytes() 方法时，默认的编码方式不是 UTF-16be。双字节编码的好处是可以使用一个 char 存储中文和英文，而将 String 转为 bytes[] 字节数组就不再需要这个好处，因此也就不再需要双字节编码。getBytes() 的默认编码方式与平台有关，一般为 UTF-8。

```java
byte[] bytes = str1.getBytes();
```

## Reader 与 Writer

不管是磁盘还是网络传输，最小的存储单元都是字节，而不是字符。但是在程序中操作的通常是字符形式的数据，因此需要提供对字符进行操作的方法。

- InputStreamReader 实现从字节流解码成字符流；
- OutputStreamWriter 实现字符流编码成为字节流。

## 实现逐行输出文本文件的内容

```java
public static void readFileContent(String filePath) throws IOException {

    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
    }

    // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
    // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
    // 因此只要一个 close() 调用即可
    bufferedReader.close();
}
```

# 五、对象操作

## 序列化

序列化就是将一个对象转换成字节序列，方便存储和传输。

- 序列化：ObjectOutputStream.writeObject()
- 反序列化：ObjectInputStream.readObject()

不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态。

## Serializable

序列化的类需要实现 Serializable 接口，它只是一个标准，没有任何方法需要实现，但是如果不去实现它的话而进行序列化，会抛出异常。

```java
public static void main(String[] args) throws IOException, ClassNotFoundException {

    A a1 = new A(123, "abc");
    String objectFile = "file/a1";

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
    objectOutputStream.writeObject(a1);
    objectOutputStream.close();

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
    A a2 = (A) objectInputStream.readObject();
    objectInputStream.close();
    System.out.println(a2);
}

private static class A implements Serializable {

    private int x;
    private String y;

    A(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + "  " + "y = " + y;
    }
}
```

## transient

transient 关键字可以使一些属性不会被序列化。

ArrayList 中存储数据的数组 elementData 是用 transient 修饰的，因为这个数组是动态扩展的，并不是所有的空间都被使用，因此就不需要所有的内容都被序列化。通过重写序列化和反序列化方法，使得可以只序列化数组中有内容的那部分数据。

```java
private transient Object[] elementData;
```

# 六、网络操作

Java 中的网络支持：

- InetAddress：用于表示网络上的硬件资源，即 IP 地址；
- URL：统一资源定位符；
- Sockets：使用 TCP 协议实现网络通信；
- Datagram：使用 UDP 协议实现网络通信。

## InetAddress

没有公有的构造函数，只能通过静态方法来创建实例。

```java
InetAddress.getByName(String host);
InetAddress.getByAddress(byte[] address);
```

## URL

可以直接从 URL 中读取字节流数据。

```java
public static void main(String[] args) throws IOException {

    URL url = new URL("http://www.baidu.com");

    /* 字节流 */
    InputStream is = url.openStream();

    /* 字符流 */
    InputStreamReader isr = new InputStreamReader(is, "utf-8");

    /* 提供缓存功能 */
    BufferedReader br = new BufferedReader(isr);

    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }

    br.close();
}
```

## Sockets

- ServerSocket：服务器端类
- Socket：客户端类
- 服务器和客户端通过 InputStream 和 OutputStream 进行输入输出。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/1e6affc4-18e5-4596-96ef-fb84c63bf88a.png" width="550px"> </div><br>

## Datagram

- DatagramSocket：通信类
- DatagramPacket：数据包类

# 七、NIO

新的输入/输出 (NIO) 库是在 JDK 1.4 中引入的，弥补了原来的 I/O 的不足，提供了高速的、面向块的 I/O。NIO中的N可以理解为Non-blocking，不单纯是New

NIO的特性/NIO与IO区别:
- IO是面向流的，NIO是面向缓冲区的；
- IO流是阻塞的，NIO流是不阻塞的;
- NIO有选择器，而IO没有。

读数据和写数据方式:
- 从通道进行数据读取 ：创建一个缓冲区，然后请求通道读取数据。
- 从通道进行数据写入 ：创建一个缓冲区，填充数据，并要求通道写入数据。

NIO核心组件简单介绍
- Channels
- Buffers
- Selectors

## 流与块

I/O 与 NIO 最重要的区别是数据打包和传输的方式，I/O 以流的方式处理数据，而 NIO 以块的方式处理数据。

面向流的 I/O 一次处理一个字节数据：一个输入流产生一个字节数据，一个输出流消费一个字节数据。为流式数据创建过滤器非常容易，链接几个过滤器，以便每个过滤器只负责复杂处理机制的一部分。不利的一面是，面向流的 I/O 通常相当慢。

面向块的 I/O 一次处理一个数据块，按块处理数据比按流处理数据要快得多。但是面向块的 I/O 缺少一些面向流的 I/O 所具有的优雅性和简单性。

I/O 包和 NIO 已经很好地集成了，java.io.\* 已经以 NIO 为基础重新实现了，所以现在它可以利用 NIO 的一些特性。例如，java.io.\* 包中的一些类包含以块的形式读写数据的方法，这使得即使在面向流的系统中，处理速度也会更快。

## 通道

通道 Channel 是对原 I/O 包中的流的模拟，可以通过它读取和写入数据。

通道与流的不同之处在于，流只能在一个方向上移动(一个流必须是 InputStream 或者 OutputStream 的子类)，而通道是双向的，可以用于读、写或者同时用于读写。

通道包括以下类型：

- FileChannel：从文件中读写数据；
- DatagramChannel：通过 UDP 读写网络中数据；
- SocketChannel：通过 TCP 读写网络中数据；一般是客户端实现
- ServerSocketChannel：可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel。一般是服务器实现

特殊操作
- Scatter / Gather
  - Scatter: 从一个Channel读取的信息分散到N个缓冲区中(Buufer)
  - Gather: 将N个Buffer里面内容按照顺序发送到一个Channel

通道之间的数据传输：在Java NIO中如果一个channel是FileChannel类型的，那么他可以直接把数据传输到另一个channel。
- transferFrom() :transferFrom方法把数据从通道源传输到FileChannel
- transferTo() :transferTo方法把FileChannel数据传输到另一个channel

## 缓冲区

Java NIO Buffers用于和NIO Channel交互。发送给一个通道的所有数据都必须首先放到缓冲区中，同样地，从通道中读取的任何数据都要先读到缓冲区中。也就是说，不会直接对通道进行读写数据，而是要先经过缓冲区。

缓冲区实质上是一个数组(一块内存区)，但它不仅仅是一个数组。缓冲区提供了对数据的结构化访问，而且还可以跟踪系统的读/写进程。

<div align="center"> 

![](../../assets/cs-note/java-io/channels-buffers.png ':size=300')
</div>


缓冲区包括以下类型：

- ByteBuffer
- CharBuffer
- ShortBuffer
- IntBuffer
- LongBuffer
- FloatBuffer
- DoubleBuffer

Buffer的常见方法
- Buffer clear()
- Buffer flip()
- Buffer rewind()
- Buffer position(int newPosition)

### 缓冲区状态变量

- capacity：最大容量；
- position：当前已经读写的字节数；
- limit：还可以读写的字节数。

状态变量的改变过程举例：

① 新建一个大小为 8 个字节的缓冲区，此时 position 为 0，而 limit = capacity = 8。capacity 变量不会改变，下面的讨论会忽略它。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/1bea398f-17a7-4f67-a90b-9e2d243eaa9a.png"/> </div><br>

② 从输入通道中读取 5 个字节数据写入缓冲区中，此时 position 为 5，limit 保持不变。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/80804f52-8815-4096-b506-48eef3eed5c6.png"/> </div><br>

③ 在将缓冲区的数据写到输出通道之前，需要先调用 flip() 方法，这个方法将 limit 设置为当前 position，并将 position 设置为 0。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/952e06bd-5a65-4cab-82e4-dd1536462f38.png"/> </div><br>

④ 从缓冲区中取 4 个字节到输出缓冲中，此时 position 设为 4。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/b5bdcbe2-b958-4aef-9151-6ad963cb28b4.png"/> </div><br>

⑤ 最后需要调用 clear() 方法来清空缓冲区，此时 position 和 limit 都被设置为最初位置。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/67bf5487-c45d-49b6-b9c0-a058d8c68902.png"/> </div><br>

## 选择器

NIO 常常被叫做非阻塞 IO，主要是因为 NIO 在网络通信中的非阻塞特性被广泛使用。

NIO 实现了 IO 多路复用中的 Reactor 模型，一个线程 Thread 使用一个选择器 Selector 通过轮询的方式去监听多个通道 Channel 上的事件，从而让一个线程就可以处理多个事件。

通过配置监听的通道 Channel 为非阻塞，那么当 Channel 上的 IO 事件还未到达时，就不会进入阻塞状态一直等待，而是继续轮询其它 Channel，找到 IO 事件已经到达的 Channel 执行。

因为创建和切换线程的开销很大，因此使用一个线程来处理多个事件而不是一个线程处理一个事件，对于 IO 密集型的应用具有很好地性能。

应该注意的是，只有套接字(Socket) Channel 才能配置为非阻塞，而 FileChannel 不能，为 FileChannel 配置非阻塞也没有意义。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/093f9e57-429c-413a-83ee-c689ba596cef.png" width="350px"> </div><br>

要使用Selector的话，我们必须把Channel注册到Selector上，然后就可以调用Selector的select()方法。这个方法会进入阻塞，直到有一个channel的状态符合条件。当方法返回后，线程可以处理这些事件。

### 1. 创建选择器

```java
Selector selector = Selector.open();
```

### 2. 将通道注册到选择器上

```java
ServerSocketChannel ssChannel = ServerSocketChannel.open();
ssChannel.configureBlocking(false);//Channel必须是非阻塞的
ssChannel.register(selector, SelectionKey.OP_ACCEPT);
```

通道必须配置为非阻塞模式，否则使用选择器就没有任何意义了，因为如果通道在某个事件上被阻塞，那么服务器就不能响应其它事件，必须等待这个事件处理完毕才能去处理其它事件，显然这和选择器的作用背道而驰。

在将通道注册到选择器上时，还需要指定要注册的具体事件，主要有以下几类：

- SelectionKey.OP_CONNECT
- SelectionKey.OP_ACCEPT
- SelectionKey.OP_READ
- SelectionKey.OP_WRITE

它们在 SelectionKey 的定义如下：

```java
public static final int OP_READ = 1 << 0;
public static final int OP_WRITE = 1 << 2;
public static final int OP_CONNECT = 1 << 3;
public static final int OP_ACCEPT = 1 << 4;
```

可以看出每个事件可以被当成一个位域，从而组成事件集整数。例如：

```java
int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
```

### 3. 监听事件

```java
int num = selector.select();
```

使用 select() 来监听到达的事件，它会一直阻塞直到有至少一个事件到达。

### 4. 获取到达的事件

```java
Set<SelectionKey> keys = selector.selectedKeys();
Iterator<SelectionKey> keyIterator = keys.iterator();
while (keyIterator.hasNext()) {
    SelectionKey key = keyIterator.next();
    if (key.isAcceptable()) {
        // ...
    } else if (key.isReadable()) {
        // ...
    }
    keyIterator.remove();
}
```

### 5. 事件循环

因为一次 select() 调用不能处理完所有的事件，并且服务器端有可能需要一直监听事件，因此服务器端处理事件的代码一般会放在一个死循环内。

```java
while (true) {
    int num = selector.select();
    Set<SelectionKey> keys = selector.selectedKeys();
    Iterator<SelectionKey> keyIterator = keys.iterator();
    while (keyIterator.hasNext()) {
        SelectionKey key = keyIterator.next();
        if (key.isAcceptable()) {
            // ...
        } else if (key.isReadable()) {
            // ...
        }
        keyIterator.remove();
    }
}
```
## 文件 NIO 实例

FileChannel的一般使用规则
1. 开启FileChannel：需要通过 InputStream ， OutputStream 或 RandomAccessFile 获取FileChannel
2. 从FileChannel读取数据/写入数据：FileChannel中读取数据/写入数据之前首先要创建一个Buffer(缓冲区）对象，
3. 关闭FileChannel


以下展示了使用 NIO 快速复制文件的实例：

```java
public static void fastCopy(String src, String dist) throws IOException {
    /* 获得源文件的输入字节流 */
    FileInputStream fin = new FileInputStream(src);
    /* 获取输入字节流的文件通道 */
    FileChannel fcin = fin.getChannel();
    /* 获取目标文件的输出字节流 */
    FileOutputStream fout = new FileOutputStream(dist);
    /* 获取输出字节流的文件通道 */
    FileChannel fcout = fout.getChannel();
    /* 为缓冲区分配 1024 个字节 */
    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    while (true) {
        /* 从输入通道中读取数据到缓冲区中 */
        int r = fcin.read(buffer);
        /* read() 返回 -1 表示 EOF */
        if (r == -1) {
            break;
        }
        /* 切换读写 */
        buffer.flip();
        /* 把缓冲区的内容写入输出文件中 */
        fcout.write(buffer);
        /* 清空缓冲区 */
        buffer.clear();
    }
}
```

## 套接字 NIO 实例

客户端
1. 通过SocketChannel连接到远程服务器
2. 创建读数据/写数据缓冲区对象来读取服务端数据或向服务端发送数据
3. 关闭SocketChannel

服务端
1. 通过ServerSocketChannel 绑定ip地址和端口号
2. 通过ServerSocketChannelImpl的accept()方法创建一个SocketChannel对象用户从客户端读/写数据
3. 创建读数据/写数据缓冲区对象来读取客户端数据或向客户端发送数据
4. 关闭SocketChannel和ServerSocketChannel

```java
public class NIOServer {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        while (true) {

            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {

                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                    // 服务器会为每个新连接创建一个 SocketChannel
                    SocketChannel sChannel = ssChannel1.accept();
                    sChannel.configureBlocking(false);

                    // 这个新连接主要用于从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);

                } else if (key.isReadable()) {

                    SocketChannel sChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }

                keyIterator.remove();
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true) {

            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == -1) {
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }
}
```

```java
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
```
## 其他实例

- [Java NIO DatagramChannel数据报通道](http://wiki.jikexueyuan.com/project/java-nio-zh/java-nio-datagramchannel.html)
- [Java NIO Pipe管道](http://wiki.jikexueyuan.com/project/java-nio-zh/java-nio-pipe.html)

## Scatter / Gather

Channel 提供了一种被称为 Scatter/Gather 的新功能，也称为本地矢量 I/O。Scatter/Gather 是指在多个缓冲区上实现一个简单的 I/O 操作。正确使用 Scatter / Gather可以明显提高性能。

Scatter/Gather应该使用直接的ByteBuffers以从本地I/O获取最大性能优势。

Scatter/Gather功能是通道(Channel)提供的 并不是Buffer。
- Scatter: 从一个Channel读取的信息分散到N个缓冲区中(Buufer)
- Gather: 将N个Buffer里面内容按照顺序发送到一个Channel

<div align="center"> 

![](../../assets/cs-note/java-io/scatter.png ':size=300')
</div>

"**scattering read**"是把数据从单个Channel写入到多个buffer：read()方法内部会负责把数据按顺序写进传入的buffer数组内。一个buffer写满后，接着写到下一个buffer中

<div align="center"> 

![](../../assets/cs-note/java-io/gather.png ':size=300')
</div>

"**gathering write**"把多个buffer的数据写入到同一个channel中：write()方法内部会负责把数据按顺序写入到channel中

**注意**：并不是所有数据都写入到通道，写入的数据要根据position和limit的值来判断，只有position和limit之间的数据才会被写入

**注意**：无论是scatter还是gather操作，都是按照buffer在数组中的顺序来依次读取或写入的

## 内存映射文件

这个功能主要是为了提高大文件的读写速度而设计的。内存映射文件(memory-mappedfile)能让你创建和修改那些大到无法读入内存的文件。

有了内存映射文件，你就可以认为文件已经全部读进了内存，然后把它当成一个非常大的数组来访问了。将文件的一段区域映射到内存中，比传统的文件处理速度要快很多。内存映射文件它虽然最终也是要从磁盘读取数据，但是它并不需要将数据读取到OS内核缓冲区，而是直接将进程的用户私有地址空间中的一部分区域与文件对象建立起映射关系，就好像直接从内存中读、写文件一样，速度当然快了。

内存映射文件 I/O 是一种读和写文件数据的方法，它可以比常规的基于流或者基于通道的 I/O 快得多。

向内存映射文件写入可能是危险的，只是改变数组的单个元素这样的简单操作，就可能会直接修改磁盘上的文件。修改数据与将数据保存到磁盘是没有分开的。

NIO中内存映射主要用到以下两个类：
- java.nio.MappedByteBuffer
- java.nio.channels.FileChannel

下面代码行将文件的前 1024 个字节映射到内存中，map() 方法返回一个 MappedByteBuffer，它是 ByteBuffer 的子类。因此，可以像使用其他任何 ByteBuffer 一样使用新映射的缓冲区，操作系统会在需要时负责执行映射。

```java
MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
```

内存映射文件的优点：
- 用户进程将文件数据视为内存，因此不需要发出read()或write()系统调用
- 当用户进程触摸映射的内存空间时，将自动生成页面错误，以从磁盘引入文件数据。 如果用户修改映射的内存空间，受影响的页面将自动标记为脏，并随后刷新到磁盘以更新文件
- 操作系统的虚拟内存子系统将执行页面的智能缓存，根据系统负载自动管理内存
- 数据始终是页面对齐的，不需要缓冲区复制
- 可以映射非常大的文件，而不消耗大量内存来复制数据。

# BIO,NIO,AIO

Java 中的 BIO、NIO和 AIO 理解为是 Java 语言对操作系统的各种 IO 模型的封装。

同步与异步
- 同步： 同步就是发起一个调用后，被调用者未处理完请求之前，调用不返回。
- 异步： 异步就是发起一个调用后，立刻得到被调用者的回应表示已接收到请求，但是被调用者并没有返回结果，此时我们可以处理其他的请求，被调用者通常依靠事件，回调等机制来通知调用者其返回结果。

阻塞和非阻塞
- 阻塞： 阻塞就是发起一个请求，调用者一直等待请求结果返回，也就是当前线程会被挂起，无法从事其他任务，只有当条件就绪才能继续。
- 非阻塞： 非阻塞就是发起一个请求，调用者不用一直等着结果返回，可以先去干其他事情。

BIO:同步阻塞I/O模式，数据的读取写入必须阻塞在一个线程内等待其完成。
NIO:同步非阻塞的I/O模型
AIO:异步非阻塞的I/O模型

## BIO(Blocking I/O)

同步阻塞I/O模式，数据的读取写入必须阻塞在一个线程内等待其完成。

**传统BIO**

BIO通信(一请求一应答）模型图如下

<div align="center"> 

![](../../assets/cs-note/java-io/BIO通信模型.png)
</div>

采用 BIO 通信模型 的服务端，通常由一个独立的 Acceptor 线程负责监听客户端的连接。我们一般通过在while(true) 循环中服务端会调用 accept() 方法等待接收客户端的连接的方式监听请求，请求一旦接收到一个连接请求，就可以建立通信套接字在这个通信套接字上进行读写操作，此时不能再接收其他客户端连接请求，只能等待同当前连接的客户端的操作执行完成， 不过可以通过多线程来支持多个客户端的连接，如上图所示。

如果要让 BIO 通信模型 能够同时处理多个客户端请求，就必须使用多线程(主要原因是socket.accept()、socket.read()、socket.write() 涉及的三个主要函数都是同步阻塞的），也就是说它在接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理，处理完成之后，通过输出流返回应答给客户端，线程销毁。这就是典型的 **一请求一应答通信模型** 。

**伪异步 IO**

为了解决同步阻塞I/O面临的一个链路需要一个线程处理的问题，后来有人对它的线程模型进行了优化一一一后端通过一个线程池来处理多个客户端的请求接入，形成客户端个数M：线程池最大线程数N的比例关系，其中M可以远远大于N.通过线程池可以灵活地调配线程资源，设置线程的最大值，防止由于海量并发接入导致线程耗尽。

伪异步IO模型图

<div align="center"> 

![](../../assets/cs-note/java-io/伪异步IO模型.png)
</div>

采用线程池和任务队列可以实现一种叫做伪异步的 I/O 通信框架，它的模型图如上图所示。当有新的客户端接入时，将客户端的 Socket 封装成一个Task(该任务实现java.lang.Runnable接口）投递到后端的线程池中进行处理，JDK 的线程池维护一个消息队列和 N 个活跃线程，对消息队列中的任务进行处理。由于线程池可以设置消息队列的大小和最大线程数，因此，它的资源占用是可控的，无论多少个客户端并发访问，都不会导致资源的耗尽和宕机。

伪异步I/O通信框架采用了线程池实现，因此避免了为每个请求都创建一个独立线程造成的线程资源耗尽问题。不过因为它的底层仍然是同步阻塞的BIO模型，因此无法从根本上解决问题。

在活动连接数不是特别高(小于单机1000）的情况下，这种模型是比较不错的，可以让每一个连接专注于自己的 I/O 并且编程模型简单，也不用过多考虑系统的过载、限流等问题。线程池本身就是一个天然的漏斗，可以缓冲一些系统处理不了的连接或请求。但是，当面对十万甚至百万级连接的时候，传统的 BIO 模型是无能为力的。因此，我们需要一种更高效的 I/O 处理模型来应对更高的并发量。

## NIO(Non-blocking I/O)

NIO中的N可以理解为Non-blocking，不单纯是New。它支持面向缓冲的，基于通道的I/O操作方法。 NIO提供了与传统BIO模型中的 Socket 和 ServerSocket 相对应的 SocketChannel 和 ServerSocketChannel 两种不同的套接字通道实现,两种通道都支持阻塞和非阻塞两种模式。阻塞模式使用就像传统中的支持一样，比较简单，但是性能和可靠性都不好；非阻塞模式正好与之相反。对于低负载、低并发的应用程序，可以使用同步阻塞I/O来提升开发速率和更好的维护性；对于高负载、高并发的(网络）应用，应使用 NIO 的非阻塞模式来开发。

- JDK 的 NIO 底层由 epoll 实现，该实现饱受诟病的空轮询 bug 会导致 cpu 飙升 100%
- 项目庞大之后，自行实现的 NIO 很容易出现各类 bug，维护成本较高

## AIO(Asynchronous I/O)

AIO 也就是 NIO 2。在 Java 7 中引入了 NIO 的改进版 NIO 2,它是异步非阻塞的IO模型。异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。

AIO 是异步IO的缩写，虽然 NIO 在网络操作中，提供了非阻塞的方法，但是 NIO 的 IO 行为还是同步的。对于 NIO 来说，我们的业务线程是在 IO 操作准备好时，得到通知，接着就由这个线程自行进行 IO 操作，IO操作本身是同步的。


AIO 的 I/O 操作，有两种方式的 API 可以进行：
- Future 方式:即提交一个 I/O 操作请求，返回一个 Future。然后您可以对 Future 进行检查，确定它是否完成，或者阻塞 IO 操作直到操作正常完成或者超时异常。
  - Future.get()是同步的，所以如果不仔细考虑使用场合，使用 Future 方式可能很容易进入完全同步的编程模式，从而使得异步操作成为一个摆设
- Callback 方式:即提交一个 I/O 操作请求，并且指定一个 CompletionHandler。当异步 I/O 操作完成时，便发送一个通知，此时这个 CompletionHandler 对象的 completed 或者 failed 方法将会被调用

```java
public interface CompletionHandler<V,A> {
    // 当操作完成后被调用，result 参数表示操作结果，
    // attachment 参数表示提交操作请求时的参数。
    void completed(V result, A attachment);

    // 当操作失败是调用，exc 参数表示失败原因。attachment 参数同上。
    void failed(Throwable exc, A attachment);
}
```

- V表示结果值的类型。对于异步网络通道的读写操作而言，这个结果值 V 都是整数类型，表示已经操作的卦数，如果是 -1，NIO.2 内核实现保证传递的 ByteBuffer参数不会有变化。
- A表示关联到 I/O 操作的对象的类型。用于传递操作环境。通常会封装一个连接环境。
- 如果成功则 completed 方法被调用。如果失败则 failed 方法被调用。

准备好 CompletionHandler 之后，如何使用 CompletionHandler 呢？AIO 提供四种类型的异步通道以及不同的 I/O 操作接受一个 CompletionHandler 对象，它们分别是：
- AsynchronousSocketChannel：connect，read，write
- AsynchronousFileChannel：lock，read，write
- AsynchronousServerSocketChannel：accept
- AsynchronousDatagramChannel：read，write，send，receive

[Java NIO AsynchronousFileChannel异步文件通道](http://wiki.jikexueyuan.com/project/java-nio-zh/java-nio-asynchronousfilechannel.html)

[Java NIO 异步 I/O 网络客户端程序实例](https://www.ibm.com/developerworks/cn/java/j-lo-nio2/index.html)

# 八、参考资料

- Eckel B, 埃克尔, 昊鹏, 等. Java 编程思想 [M]. 机械工业出版社, 2002.
- [IBM: NIO 入门](https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html)
- [Java NIO Tutorial](http://tutorials.jenkov.com/java-nio/index.html)
- [Java NIO 浅析](https://tech.meituan.com/nio.html)
- [IBM: 深入分析 Java I/O 的工作机制](https://www.ibm.com/developerworks/cn/java/j-lo-javaio/index.html)
- [IBM: 深入分析 Java 中的中文编码问题](https://www.ibm.com/developerworks/cn/java/j-lo-chinesecoding/index.html)
- [IBM: Java 序列化的高级认识](https://www.ibm.com/developerworks/cn/java/j-lo-serial/index.html)
- [NIO 与传统 IO 的区别](http://blog.csdn.net/shimiso/article/details/24990499)
- [Decorator Design Pattern](http://stg-tud.github.io/sedc/Lecture/ws13-14/5.3-Decorator.html#mode=document)
- [Socket Multicast](http://labojava.blogspot.com/2012/12/socket-multicast.html)


