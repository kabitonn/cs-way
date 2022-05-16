<!-- GFM-TOC -->
* [JQuery 介绍](#JQuery-介绍)
  * [JQuery 简介](#JQuery-简介)
  * [JQuery 核心](#JQuery-核心)
    * [JQuery 核心对象](#JQuery-核心对象)
    * [JQuery 对象](#JQuery-对象)
    * [注意点](#注意点)
* [JQuery 使用](#JQuery-使用)
  * [选择器](#选择器)
    * [基本选择器](#基本选择器)
    * [层叠选择器](#层叠选择器)
    * [基本过滤选择器](#基本过滤选择器)
    * [属性选择器](#属性选择器)
    * [内容过滤选择器](#内容过滤选择器)
    * [可见性选择器](#可见性选择器)
    * [表单选择器](#表单选择器)
    * [状态过滤选择器](#状态过滤选择器)
  * [筛选器方法](#筛选器方法)
    * [基本筛选器](#基本筛选器)
    * [查找筛选器](#查找筛选器)
  * [操作元素](#操作元素)
    * [操作元素内容](#操作元素内容)
    * [操作元素样式](#操作元素样式)
    * [操作元素属性](#操作元素属性)
  * [操作文档](#操作文档)
  * [事件](#事件)
    * [事件说明](#事件说明)
    * [动态事件绑定](#动态事件绑定)
    * [解除事件绑定](#解除事件绑定)
* [Ajax](#Ajax)
  * [Ajax 简介](#Ajax-简介)
  * [Ajax 工作原理](#Ajax-工作原理)
  * [Ajax 使用](#Ajax-使用)
    * [原生 Ajax使用](#原生-Ajax使用)
    * [JQuery中的Ajax](#JQuery中的Ajax)
* [Axios](#Axios)
  * [axios 简介](#axios-简介)
  * [axios API](#axios-API)
    * [请求方法别名](#请求方法别名)
    * [并发请求](#并发请求)
    * [请求配置](#请求配置)
    * [响应结构](#响应结构)
  * [创建实例](#创建实例)
    * [实例方法](#实例方法)
  * [配置默认值](#配置默认值)
    * [全局的 axios 默认值](#全局的-axios-默认值)
    * [实例默认值](#实例默认值)
    * [配置的优先顺序](#配置的优先顺序)
  * [数据处理](#数据处理)
    * [拦截器](#拦截器)
    * [错误处理](#错误处理)
    * [取消](#取消)
<!-- GFM-TOC -->


# JQuery 介绍

## JQuery 简介

jQuery 全称 javaScript Query 是js的一个框架。

1. jquery是由美国人John Resig创建，至今已吸引了来自世界各地的众多 javascript高手加入其team。
2. jQuery是继prototype之后又一个优秀的Javascript框架。其宗旨是——WRITE LESS,DO MORE!
3. 它是轻量级的js库(压缩后只有21k) ，这是其它的js库所不及的，它兼容CSS3，还兼容各种浏览器
4. jQuery是一个快速的，简洁的javaScript库，使用户能更方便地处理HTMLdocuments、events、实现动画效果，并且方便地为网站提供AJAX交互。
5. jQuery还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择

JQuery的特点 
- 支持各种主流的浏览器。 
- 使用特别简单 
- 拥有便捷的插件扩展机制和丰富的插件

**封装原理**
- js的全局代码区只有一个，这样就会造成同名变量的值会被覆盖。
- 使用对象封装，将代码封装到对象中.但是对象如果被覆盖，则全部失效，风险极高。
- 使用工厂模式,将代码进行封装，但是并没有解决问题
- 将封装的函数名字去除，避免覆盖。但是函数没有办法调用了。
- 匿名自调用，可以在页面加载的时候调用一次。但是不能重复调用，并且数据没有办法获取
- 使用闭包,将数据一次性挂载到window对象下
- 闭包原理:在全局区中不能够获取函数体内的数据。使用更大作用域的变量来记录小作用域变量的值。

## JQuery 核心

### JQuery 核心对象

`window.jQuery = window.$ = jQuery;`

- 在window对象中，多了两个属性，叫做jQuery 和 $
- jQuery属性 和 $可以相互替代

### JQuery 对象

jQuery 对象就是通过jQuery包装DOM对象后产生的对象。jQuery 对象是 jQuery 独有的。

虽然jQuery对象是包装DOM对象后产生的，但是jQuery无法使用DOM对象的任何方法，同理DOM对象也不能使用jQuery里的方法

jQuery的基础语法：$(selector).action()

**JQuery对象和DOM对象互相转换**
```js
//DOM --> jquery
let $div= $(dom对象);
//jquery ---> DOM
let div = $div[0]
```

### 注意点

任何jQuery 元素对象的赋值操作，基本上都是通过方法的第二个参数赋值，不会出现 =

# JQuery 使用

## 选择器

jQuery中选择器获取的是存储了HTML元素对象的数组。

jQuery获取的元素对象不能够直接使用js的内容，按照数组的取出方式将对象取出后可以使用js的内容。

### 基本选择器


| 名称       | 选择器   | 实例              | 选取说明                      |
| ---------- | -------- | ----------------- | ----------------------------- |
| 全部选择器 | \*       | $("*")            | 所有元素                      |
| id选择器   | #id      | $("#id")          | id="id" 的元素                |
| 类选择器   | .class   | $(".classname")   | 所有 class="classname" 的元素 |
| 标签选择器 | element  | $("p")            | 所有 `<p>` 元素               |
| 组合选择器 | s1,s2,s3 | $("th,td,.intro") | 所有带有匹配选择的元素        |

### 层叠选择器

| 名称           |               |                                                                                    |
| -------------- | ------------- | ---------------------------------------------------------------------------------- |
| 后代选择器     | $(div span)   | 选取某元素的后代元素                                                               |
| 子元素选择器   | $(div > span) | 选择作为某元素子元素的元素                                                         |
| 相邻兄弟选择器 | $(div + div ) | 选择紧接在另一元素后的元素，且二者有相同父元素  -----相同写法  $(div).next("div"); |
| 普通兄弟选择器 | $(div ~ div)  | 选取所有指定元素之后的相邻兄弟元素       -----相同写法  $(div).nextAll("div");     |

### 基本过滤选择器
| 选择器         | 实例                   | 选取说明                              |
| -------------- | ---------------------- | ------------------------------------- |
| :first         | $("p:first")           | 第一个 `<p>` 元素                     |
| :last          | $("p:last")            | 最后一个 `<p>` 元素                   |
| :even          | $("tr:even")           | 所有偶数 `<tr>` 元素                  |
| :odd           | $("tr:odd")            | 所有奇数 `<tr>` 元素                  |
|                |                        |                                       |
| :eq(index)     | $("ul li:eq(3)")       | 列表中的第四个元素（index 从 0 开始） |
| :gt(no)        | $("ul li:gt(3)")       | 列出 index 大于 3 的元素              |
| :lt(no)        | $("ul li:lt(3)")       | 列出 index 小于 3 的元素              |
| :not(selector) | $("input:not(:empty)") | 所有不为空的 input 元素               |
|                |                        |                                       |
| :header        | $(":header")           | 所有标题元素 `<h1> - <h6>`            |
| :animated      |                        | 所有动画元素                          |

### 属性选择器

| 选择器             | 实例                | 选取说明                                   |
| ------------------ | ------------------- | ------------------------------------------ |
| [attribute]        | $("[href]")         | 所有带有 href 属性的元素                   |
| [attribute=value]  | $("[href='#']")     | 所有 href 属性的值等于 "#" 的元素          |
| [attribute!=value] | $("[href!='#']")    | 所有 href 属性的值不等于 "#" 的元素        |
| [attribute$=value] | $("[href$='.jpg']") | 所有 href 属性的值包含以 ".jpg" 结尾的元素 |

### 内容过滤选择器

| 选择器          | 实例                       | 选取说明                   |
| --------------- | -------------------------- | -------------------------- |
| :contains(text) | $(":contains('W3School')") | 包含指定字符串的所有元素   |
| :empty          | $(":empty")                | 无子（元素）节点的所有元素 |

### 可见性选择器

| 选择器   | 实例               | 选取说明                     |
| -------- | ------------------ | ---------------------------- |
| :hidden  | $("p:hidden")      | 所有隐藏的 `<p>` 元素        |
| :visible | $("table:visible") | 所有可见的表格               |
| :has     | $("td:has('p')")   | 选择该元素有p标签的元素      |
| :parent  | $("td:parent")     | 选择含有子元素或者文本的元素 |

### 表单选择器

| 选择器    | 实例           | 选取说明                               |
| --------- | -------------- | -------------------------------------- |
| :input    | $(":input")    | 所有 `<input>` 元素                    |
| :text     | $(":text")     | 所有 type="text" 的 `<input>` 元素     |
| :password | $(":password") | 所有 type="password" 的 `<input>` 元素 |
| :radio    | $(":radio")    | 所有 type="radio" 的 `<input>` 元素    |
| :checkbox | $(":checkbox") | 所有 type="checkbox" 的 `<input>` 元素 |
| :submit   | $(":submit")   | 所有 type="submit" 的 `<input>` 元素   |
| :reset    | $(":reset")    | 所有 type="reset" 的 `<input>` 元素    |
| :button   | $(":button")   | 所有 type="button" 的 `<input>` 元素   |
| :image    | $(":image")    | 所有 type="image" 的 `<input>` 元素    |
| :file     | $(":file")     | 所有 type="file" 的 `<input>` 元素     |

### 状态过滤选择器

| 选择器    | 实例           | 选取说明               |
| --------- | -------------- | ---------------------- |
| :enabled  | $(":enabled")  | 所有启用的元素         |
| :disabled | $(":disabled") | 所有禁用的元素         |
| :selected | $(":selected") | 所有选定的下拉列表元素 |
| :checked  | $(":checked")  | 所有选中的复选框选项   |

## 筛选器方法

### 基本筛选器

- .first() ---获取匹配的第一个元素
- .last() ---获取匹配的最后一个元素
- .not() ---从匹配元素的集合中删除与指定表达式匹配的元素
- .has() ---保留包含特定后代的元素，去掉那些不含有指定后代的元素。
- .eq() ---索引值等于指定值的元素


### 查找筛选器
- .children()   ---返回匹配元素集合中每个元素的所有子元素（仅儿子辈）。参数可选，添加参数表示通过选择器进行过滤，对元素进行筛选
- .find()   ---方法是返回匹配元素集合中每个元素的后代。参数是必选的，可以为选择器、jquery对象可元素来对元素进行筛选。      
- .siblings(expr) 查找所有兄弟（包括哥哥和弟弟）
- .next(expr) ---查找紧挨着的弟弟
- .nextAll(expr) ---查找所有的弟弟
- .nextUntil(expr) ---查找所有弟弟，直到碰到符合expr条件，不包含符合expr条件的那个元素
- .prev(expr) ---查找紧挨着的哥哥
- .prevAll(expr) ---查找所有哥哥
- .prevUntil(expr) ---查找所有哥哥，直到碰到符合expr条件，不包含符合expr条件的那个元素
- .parent()   ---查找当前元素的父元素
- .parents()  ---查找当前元素的所有的父辈元素（爷爷辈、祖先辈都找到）

**expr** 是指可选的参数，包含用于匹配元素的选择器表达式。

## 操作元素

### 操作元素内容

- $().html() 无参取值，有参赋值，注意：取值取标签，赋值解析标签
- $().text() 无参取值，有参赋值，注意：取值不取标签，赋值不解析标签
- $().val()  无参取值，有参赋值，相当于表单组件的value

### 操作元素样式

**访问class**
- $().addClass("样式名") 添加样式
- $().removeClass("样式名") 移除指定的CSS类名
- $().removeClass() 移除所有样式
- $().hasClass() 判断样式存不存在
- $().toggleClass(“样式名”) 切换CSS类名，有则删除，没有则添加

**访问css**
- $().css("样式名") 取值操作 ( 原始css样式 background-color )
- $().css("样式名","样式值") 赋值操作
- $().css({}) 一次性修改多个css样式，参数是json对象，对象属性名是css属性名，对象值是css属性值
- $().width() 、 $().height() 无参取值，有参赋值

### 操作元素属性

**attr()** 查看设置属性
- $().attr(attribute)  查看该属性的值 
- $().attr(attribute, "xx")// 设置一个属性值
- $().attr({k1: v1, k2:v2})// 设置多个属性值，参数是json对象
- $().removeAttr("属性")// 从每一个匹配的元素中删除一个属性

**prop()** 查看,设置属性的状态(主要应用于:checked,selected,disabled)
- prop("checked")
- prop("checked",true) //设置为选中
- prop("checked",false) //取消选中

## 操作文档

**内部插入**
- $(a).append(b)        //将b添加到a标签里面
- $(a).appendTo(b)      //与上面的相反
- $(a).prepend(b)       //前置添加
- $(a).prependTo(b)     //与上面的相反

**外部插入**
- $(a).after(b)         //将后者放到前者的后面
- $(a).insertAfter(b)   //把前者放到后者的后面
- $(a).before(b)        // 将后者放到前者的前面
- $(a).insertBefore(b)  //把前者放到后者的前面

**包裹**

**替换**
- $(a).replaceWith(b)   //前者被后者所取代(替换)
- $(a).replaceAll(b)    //前者取代后者(替换)

**删除**
- remove()              //方法删除被选元素及其子元素
- empty()               //方法删除被选元素的子元素

## 事件



### 事件说明

事件名指的是：原始JavaScript事件，去掉on。

| 事件       | 触发条件                                                                                                   |
| ---------- | ---------------------------------------------------------------------------------------------------------- |
| click      | 鼠标单击后,触发...                                                                                         |
| dblclick   | 鼠标双击后,触发..                                                                                          |
| mouseenter | 当鼠标指针经过或悬停在被选元素时,触发...                                                                   |
| mouseleave | 当鼠标指针离开被选元素时，会发生 mouseleave 事件。                                                         |
| keypress   | 键被按下                                                                                                   |
| keydown    | 键按下的过程                                                                                               |
| keyup      | 键被松开                                                                                                   |
| hover      | 鼠标指针悬停在被选元素上时要运行的两个函数。方法触发mouseenter和mouseleave事件(实际上是对这俩方法的封装)   |
| submit()   | 当提交表单时,触发...                                                                                       |
| change()   | 当元素的值改变时(仅适用于表单字段),触发...                                                                 |
| focus()    | 当元素获得焦点时（当通过鼠标点击选中元素或通过 tab 键定位到元素时）触发...(该方法通常与blur()方法一起使用) |
| blur       | 当元素失去焦点时,触发...                                                                                   |
| resize     | 当调整浏览器窗口大小时，触发...                                                                            |
| scroll     | 当用户滚动指定的元素时，触发...                                                                            |

### 动态事件绑定

- $().事件名(事件处理函数)          $("#d").click(function(){})
- $().on("事件名",事件处理函数)     $("#d").on("click",function(){})
- $().bind("事件名",事件处理函数)   $("#d").bind("click",function(){})
  - js中的是一次添加，多次添加时覆盖的效果
  - jQuery是追加的效果，可以实现给一个事件添加不同的监听函数。
- $().one("事件名",事件处理函数)
- $().trigger("事件名",事件处理函数)

**页面载入事件**：当HTML页面完成加载时触发函数指定的函数的执行，类似onload事件
- $(dcoument).ready(function(){ 函数体 })
- $(function(){ 函数体 })
- 特点:可以同时声明多个函数，不会被覆盖。

### 解除事件绑定

$().unbind("事件名")


# Ajax

## Ajax 简介

AJAX = Asynchronous JavaScript and XML（异步的 JavaScript 和 XML）。

AJAX 最大的优点是在不重新加载整个页面的情况下，可以与服务器交换数据并更新部分网页内容。

Ajax本身属于js内核中的一部分，jQuery是js的一个框架，是对js的封装，因此jQuery中也维护着Ajax的内容。

## Ajax 工作原理

页面发起请求，会将请求发送给浏览器内核中的Ajax引擎，Ajax引擎会提交请求到服务器端，在这段时间里，客户端可以进行任意操作，知道服务器端将数据返回给Ajax引擎后，会触发你设置的事件，从而执行自定义的js逻辑代码完成某种页面功能。

ajax是前端的技术，由浏览器进行解析执行。

![](../../assets/cs-note/preface/basic/ajax-yl.png)


## Ajax 使用

- 创建异步对象。即 XMLHttpRequest 对象。
- 设置请求的参数。包括：请求的方法、请求的url。
- 发送请求。
- 注册事件。 onreadystatechange事件，状态改变时就会调用。
- 获取返回的数据。
  - 普通文本：后台在接收到ajax请求后，处理后直接响应普通字符串给ajax
  - json数据：后台在接收到ajax请求后，处理后响应json格式的字符串给ajax，ajax处理代码中使用eval()方法将json数据转换为js对的对象，将对象中的数据通过js的dom操作显示到页面中。
  - xml：后台在接收到ajax请求后，处理后响应xml格式的字符串给ajax。前台使用ajax.responseXML进行数据接收，返回的是xml文档对象(document)。使用document对象将xml中取出并显示到页面中即可。注意：后台的响应数据格式必须设置成xml格式：

### 原生 Ajax使用

- 创建ajax引擎对象
- 覆写onreadystatechange函数
  - 判断数据状态码
  - 判断响应状态码
  - 获取响应数据
  - 处理响应信息
- 创建并发送请求
  - get请求
```js
//get的请求实体拼接在URL后面，？隔开，键值对
ajax.open("get","url");
ajax.send(null);
```
  - post请求
```js
//有单独的请求实体
ajax.open("post", "url");
ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
ajax.send("name=张三&pwd=123");
```
- ajax的状态码
  - 0 表示XMLHttpRequest已建立，但还未初始化，这时尚未调用open方法 
  - 1 表示open方法已经调用，但未调用send方法（已创建，未发送） 
  - 2 表示send方法已经调用，其他数据未知 
  - 3 表示请求已经成功发送，正在接受数据 
  - 4 表示数据已经成功接收。 
- ajax的异步和同步:ajax.open(method,urL,async)
- 封装：相同的保留，不同的传参。最终封装成一个js文件。


### JQuery中的Ajax

与Ajax操作相关的jQuery方法很多种，但开发中常用的有三种：
- $.get(url, [data], [callback], [type]);
  - String url：待载入页面的url地址
  - Map data（可选）：待发送key/value参数
  - Function callback（可选）：载入成功时的回调函数
  - String type（可选）：返回内容格式，xml，html，script，json，text，_default
- $.post(url, [data], [callback], [type]);
- $.ajax({option1:value1,option2:value2});

**jQuery的ajax方法**

常用的option如下：
- async：是否异步，默认是true，代表异步
- data：发送到服务器的参数，建议使用json格式
- dataType：服务器端返回的数据类型，常用text和json
- success：成功响应执行的函数，对应的类型是function类型
- type：请求方式，GET/POST
- url：请求服务器端地址


```js
$("a").click(function(){ 
    $.ajax({ 
        url:"http://www.microsoft.com", //请求的url地址
        data:{"key":"value"},   //参数值
        async:true,             //请求是否异步，默认为异步，这也是ajax重要特性
        dataType:'json',        //返回格式为json
        type:'POST',    //请求方式
        beforeSend:function(){
            //请求前的处理
        },
        success:function(data){
            alert("请求成功"+data); //请求成功时处理
        },
        error:function(){
            alert("请求出错."); //请求出错处理
        }, 
        complete:function(){
            //请求完成的处理
        }
    }); 
    return false;
})
```

jquery 中 ajax 分类
- 第一层 $.ajax({ 属性名:值,属性名:值})
    - 是 jquery 中功能最全的，代码写起来相对最麻烦的.
- 第二层(简化$.ajax)
    - $.get(url,data,success,dataType)
    - $.post(url,data,success,dataType)
- 第三层(简化$.get())
    - $.getJSON(url,data,success) 相当于设置 $.get 中dataType="json"
    - $.getScript(url,data,success) 相当于设置 $.get 中dataType="script"



如果服务器返回数据是从表中取出.为了方便客户端操作返回的数据,服务器端返回的数据设置成 json,客户端把 json 当作对象或数组操作.

json:数据格式.
- JsonObject:json 对象,理解成 java 中对象 {"key":value,'key":value}
- JsonArray:json 数组 [{"key":value,"key":value},{}]

# Axios

## axios 简介

Axios 是一个基于 promise 的 HTTP 库，可以用在浏览器和 node.js 中。

本身具有以下**特性**
- 从浏览器中创建 XMLHttpRequest
- 从 node.js 发出 http 请求
- 支持 Promise API
- 拦截请求和响应
- 转换请求和响应数据
- 取消请求
- 自动转换JSON数据
- 客户端支持防止 CSRF/XSRF

## axios API

**axios(config)**:可以通过向 axios 传递相关配置来创建请求

**axios(url[, config])**

```js
// 发送 POST 请求
axios({
  method: 'post',
  url: '/user/12345',
  data: {
    firstName: 'Fred',
    lastName: 'Flintstone'
  }
});

// 获取远端图片
axios({
  method:'get',
  url:'http://bit.ly/2mTM3nY',
  responseType:'stream'
})
  .then(function(response) {
  response.data.pipe(fs.createWriteStream('ada_lovelace.jpg'))
});
```

### 请求方法别名

- axios.request(config)
- axios.get(url[, config])
- axios.delete(url[, config])
- axios.head(url[, config])
- axios.options(url[, config])
- axios.post(url[, data[, config]])
- axios.put(url[, data[, config]])
- axios.patch(url[, data[, config]])

**注意**：在使用别名方法时， url、method、data 这些属性都不必在配置中指定。

### 并发请求

处理并发请求的助手函数
- axios.all(iterable)
- axios.spread(callback)


### 请求配置

```js
{
   // `url` 是用于请求的服务器 URL
  url: '/user',

  // `method` 是创建请求时使用的方法
  method: 'get', // default

  // `baseURL` 将自动加在 `url` 前面，除非 `url` 是一个绝对 URL。
  // 它可以通过设置一个 `baseURL` 便于为 axios 实例的方法传递相对 URL
  baseURL: 'https://some-domain.com/api/',

  // `transformRequest` 允许在向服务器发送前，修改请求数据
  // 只能用在 'PUT', 'POST' 和 'PATCH' 这几个请求方法
  // 后面数组中的函数必须返回一个字符串，或 ArrayBuffer，或 Stream
  transformRequest: [function (data, headers) {
    // 对 data 进行任意转换处理
    return data;
  }],

  // `transformResponse` 在传递给 then/catch 前，允许修改响应数据
  transformResponse: [function (data) {
    // 对 data 进行任意转换处理
    return data;
  }],

  // `headers` 是即将被发送的自定义请求头
  headers: {'X-Requested-With': 'XMLHttpRequest'},

  // `params` 是即将与请求一起发送的 URL 参数
  // 必须是一个无格式对象(plain object)或 URLSearchParams 对象
  params: {
    ID: 12345
  },

   // `paramsSerializer` 是一个负责 `params` 序列化的函数
  // (e.g. https://www.npmjs.com/package/qs, http://api.jquery.com/jquery.param/)
  paramsSerializer: function(params) {
    return Qs.stringify(params, {arrayFormat: 'brackets'})
  },

  // `data` 是作为请求主体被发送的数据
  // 只适用于这些请求方法 'PUT', 'POST', 和 'PATCH'
  // 在没有设置 `transformRequest` 时，必须是以下类型之一：
  // - string, plain object, ArrayBuffer, ArrayBufferView, URLSearchParams
  // - 浏览器专属：FormData, File, Blob
  // - Node 专属： Stream
  data: {
    firstName: 'Fred'
  },

  // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
  // 如果请求话费了超过 `timeout` 的时间，请求将被中断
  timeout: 1000,

   // `withCredentials` 表示跨域请求时是否需要使用凭证
  withCredentials: false, // default

  // `adapter` 允许自定义处理请求，以使测试更轻松
  // 返回一个 promise 并应用一个有效的响应 (查阅 [response docs](#response-api)).
  adapter: function (config) {
    /* ... */
  },

 // `auth` 表示应该使用 HTTP 基础验证，并提供凭据
  // 这将设置一个 `Authorization` 头，覆写掉现有的任意使用 `headers` 设置的自定义 `Authorization`头
  auth: {
    username: 'janedoe',
    password: 's00pers3cret'
  },

   // `responseType` 表示服务器响应的数据类型，可以是 'arraybuffer', 'blob', 'document', 'json', 'text', 'stream'
  responseType: 'json', // default

  // `responseEncoding` indicates encoding to use for decoding responses
  // Note: Ignored for `responseType` of 'stream' or client-side requests
  responseEncoding: 'utf8', // default

   // `xsrfCookieName` 是用作 xsrf token 的值的cookie的名称
  xsrfCookieName: 'XSRF-TOKEN', // default

  // `xsrfHeaderName` is the name of the http header that carries the xsrf token value
  xsrfHeaderName: 'X-XSRF-TOKEN', // default

   // `onUploadProgress` 允许为上传处理进度事件
  onUploadProgress: function (progressEvent) {
    // Do whatever you want with the native progress event
  },

  // `onDownloadProgress` 允许为下载处理进度事件
  onDownloadProgress: function (progressEvent) {
    // 对原生进度事件的处理
  },

   // `maxContentLength` 定义允许的响应内容的最大尺寸
  maxContentLength: 2000,

  // `validateStatus` 定义对于给定的HTTP 响应状态码是 resolve 或 reject  promise 。如果 `validateStatus` 返回 `true` (或者设置为 `null` 或 `undefined`)，promise 将被 resolve; 否则，promise 将被 rejecte
  validateStatus: function (status) {
    return status >= 200 && status < 300; // default
  },

  // `maxRedirects` 定义在 node.js 中 follow 的最大重定向数目
  // 如果设置为0，将不会 follow 任何重定向
  maxRedirects: 5, // default

  // `socketPath` defines a UNIX Socket to be used in node.js.
  // e.g. '/var/run/docker.sock' to send requests to the docker daemon.
  // Only either `socketPath` or `proxy` can be specified.
  // If both are specified, `socketPath` is used.
  socketPath: null, // default

  // `httpAgent` 和 `httpsAgent` 分别在 node.js 中用于定义在执行 http 和 https 时使用的自定义代理。允许像这样配置选项：
  // `keepAlive` 默认没有启用
  httpAgent: new http.Agent({ keepAlive: true }),
  httpsAgent: new https.Agent({ keepAlive: true }),

  // 'proxy' 定义代理服务器的主机名称和端口
  // `auth` 表示 HTTP 基础验证应当用于连接代理，并提供凭据
  // 这将会设置一个 `Proxy-Authorization` 头，覆写掉已有的通过使用 `header` 设置的自定义 `Proxy-Authorization` 头。
  proxy: {
    host: '127.0.0.1',
    port: 9000,
    auth: {
      username: 'mikeymike',
      password: 'rapunz3l'
    }
  },

  // `cancelToken` 指定用于取消请求的 cancel token
  // （查看后面的 Cancellation 这节了解更多）
  cancelToken: new CancelToken(function (cancel) {
  })
}
```

### 响应结构

某个请求的响应包含以下信息
```js
{
  // `data` 由服务器提供的响应
  data: {},

  // `status` 来自服务器响应的 HTTP 状态码
  status: 200,

  // `statusText` 来自服务器响应的 HTTP 状态信息
  statusText: 'OK',

  // `headers` 服务器响应的头
  headers: {},

   // `config` 是为请求提供的配置信息
  config: {},
 // 'request'
  // `request` is the request that generated this response
  // It is the last ClientRequest instance in node.js (in redirects)
  // and an XMLHttpRequest instance the browser
  request: {}
}
```

使用 then 时，你将接收下面这样的响应 :
```js
axios.get('/user/12345')
  .then(function(response) {
    console.log(response.data);
    console.log(response.status);
    console.log(response.statusText);
    console.log(response.headers);
    console.log(response.config);
  });
```
在使用 catch 时，或传递 rejection callback 作为 then 的第二个参数时，响应可以通过 error 对象可被使用。

## 创建实例

可以使用自定义配置新建一个 **axios 实例**

axios.create([config])

### 实例方法

以下是可用的实例方法。指定的配置将与实例的配置合并
- axios#request(config)
- axios#get(url[, config])
- axios#delete(url[, config])
- axios#head(url[, config])
- axios#options(url[, config])
- axios#post(url[, data[, config]])
- axios#put(url[, data[, config]])
- axios#patch(url[, data[, config]])

## 配置默认值

可以指定将被用在各个请求的配置默认值

### 全局的 axios 默认值

```js
axios.defaults.baseURL = 'https://api.example.com';
axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
```

### 实例默认值

```js
// Set config defaults when creating the instance
const instance = axios.create({
  baseURL: 'https://api.example.com'
});

// Alter defaults after instance has been created
instance.defaults.headers.common['Authorization'] = AUTH_TOKEN;
```

### 配置的优先顺序

配置会以一个优先顺序进行合并。这个顺序是：在 lib/defaults.js 找到的库的默认值，然后是实例的 defaults 属性，最后是请求的 config 参数。后者将优先于前者。

## 数据处理

### 拦截器

在请求或响应被 then 或 catch 处理前拦截它们
```js
// 添加请求拦截器
axios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    return config;
  }, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
  });

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response;
  }, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
  });
```

如果想在稍后移除拦截器，可以这样：
```js
const myInterceptor = axios.interceptors.request.use(function () {/*...*/});
axios.interceptors.request.eject(myInterceptor);
```
可以为自定义 axios 实例添加拦截器
```js
const instance = axios.create();
instance.interceptors.request.use(function () {/*...*/});
```

### 错误处理

```js
axios.get('/user/12345')
  .catch(function (error) {
    if (error.response) {
      // The request was made and the server responded with a status code
      // that falls out of the range of 2xx
      console.log(error.response.data);
      console.log(error.response.status);
      console.log(error.response.headers);
    } else if (error.request) {
      // The request was made but no response was received
      // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
      // http.ClientRequest in node.js
      console.log(error.request);
    } else {
      // Something happened in setting up the request that triggered an Error
      console.log('Error', error.message);
    }
    console.log(error.config);
  });
```
也可以使用 validateStatus 配置选项定义一个自定义 HTTP 状态码的错误范围。
```js
axios.get('/user/12345', {
  validateStatus: function (status) {
    return status < 500; // Reject only if the status code is greater than or equal to 500
  }
})
```

### 取消

使用 cancel token 取消请求

> Axios 的 cancel token API 基于cancelable promises proposal，它还处于第一阶段。

可以使用 CancelToken.source 工厂方法创建 cancel token，像这样
```js
const CancelToken = axios.CancelToken;
const source = CancelToken.source();

axios.get('/user/12345', {
  cancelToken: source.token
}).catch(function(thrown) {
  if (axios.isCancel(thrown)) {
    console.log('Request canceled', thrown.message);
  } else {
     // 处理错误
  }
});

axios.post('/user/12345', {
  name: 'new name'
}, {
  cancelToken: source.token
})

// 取消请求（message 参数是可选的）
source.cancel('Operation canceled by the user.');
```
还可以通过传递一个 executor 函数到 CancelToken 的构造函数来创建 cancel token：
```js
const CancelToken = axios.CancelToken;
let cancel;

axios.get('/user/12345', {
  cancelToken: new CancelToken(function executor(c) {
    // executor 函数接收一个 cancel 函数作为参数
    cancel = c;
  })
});

// cancel the request
cancel();
```
**注意**: 可以使用同一个 cancel token 取消多个请求
