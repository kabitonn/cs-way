<!-- GFM-TOC -->
* [开发效率](#开发效率)
  * [常用快捷键](#常用快捷键)
  * [常用插件](#常用插件)
* [问题及配置](#问题及配置)
  * [默认配置](#默认配置)
    * [File-->Other Settings-->Preferences for New Projects](#File--Other-Settings--Preferences-for-New-Projects)
    * [File-->Other Settings-->Structure for New Projects](#File--Other-Settings--Structure-for-New-Projects)
  * [常见配置](#常见配置)
    * [自动导入引用类所在包配置](#自动导入引用类所在包配置)
    * [内存使用量展示](#内存使用量展示)
    * [悬浮提示](#悬浮提示)
    * [Ctrl+鼠标滚轴修改字体大小](#Ctrl鼠标滚轴修改字体大小)
    * [显示多行Tab](#显示多行Tab)
    * [显示行号和方法分隔符](#显示行号和方法分隔符)
    * [文档注释](#文档注释)
    * [文件模板配置](#文件模板配置)
    * [注释格式](#注释格式)
    * [leetcode 插件配置](#leetcode-插件配置)
  * [常见问题](#常见问题)
    * [编译器语言版本](#编译器语言版本)
    * [MapStruct 注解不识别](#MapStruct-注解不识别)
<!-- GFM-TOC -->



# 开发效率

## 常用快捷键


- Shift+Shift     搜索所有文件

编辑操作
- Ctrl+Alt+Enter     在当前行前插入一行
- Shift+Enter     在当前行下面增加一行
- Ctrl+Y     删除当前行
- Ctrl+Z     撤销
- Ctrl+Shift+Z     反撤销
- Ctrl+Alt+L     格式化代码
- Ctrl+Shift+U     对选中代码进行大小写转换



文件操作
- Ctrl+F     当前文件查找
- Ctrl+Shift+F     全局文件查找
- Ctrl+R     当前文件替换
- Ctrl+Shift+R     全局文件替换



调试
- F8     单步调试
- F9     跳到下一断点或结束调试
- F7     单步进入
- Shift+F8     单步跳出

注释
Ctrl+/     注释/取消注释当前行
Ctrl+Shift+/     注释/取消注释(多行，注释时选中要注释的代码，取消注释时，光标在注释内任意位置即可)

Alt+Enter     错误修复解决方案

文件切换
- Alt+上键     将光标移到上一个方法名或类名
- Alt+下键     将光标移到下一个方法名或文件结尾
- Alt+左键     切换到前一个打开的文件(打开多个文件时切换文件)
- Alt+右键     切换到前一个打开的文件(打开多个文件时切换文件)

- Ctrl+U     光标在方法名或方法内，打开重写、实现的父类方法、接口
- Ctrl+Alt+B     光标在方法名上,打开方法实现或重写
- Ctrl+H     查看选择类的继承层次结构
- 
## 常用插件

- Alibaba Java Coding Guidelines
- Free Mybatis plugin
- Git ToolBox
- JSON Parser
- Key Promoter
- leetcode editor
- Lombok
- MapStruct Support
- Maven Helper
- PlantUML
- Rainbow Brackets
- RestfulTookit
- CodeGlance

# 问题及配置

## 默认配置

### File-->Other Settings-->Preferences for New Projects

#### Maven 配置
- 版本
- settings
- repository

### File-->Other Settings-->Structure for New Projects


## 常见配置

### 自动导入引用类所在包配置

Editor -> General -> Auto Import 

### 内存使用量展示

Apperance -> Window Options -> Show Memory indicator

### 悬浮提示

Editor -> General -> show quick documention

### Ctrl+鼠标滚轴修改字体大小

Editor -> General -> change font size (zoom)

### 显示多行Tab

Editor -> General -> Editor Tabs 

1. show tabs in one row 取消勾选
2. tab limit

### 显示行号和方法分隔符

Editor -> General -> Appearance -> show line numbers / show method separators

### 文档注释

Editor -> File and Code Templates -> includes -> File Header

### 文件模板配置

Editor -> File and Code Templates -> File

Class的Java Doc文件注释

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
 * @description：TODO
 * @author     ：chenwei.tjw
 * @date       ：${DATE} ${TIME}
 */
public class ${NAME} {
}
```

### 注释格式

Editor -> Code Style -> Java -> Code Generation -> 取消勾选Line comment at first column

### leetcode 插件配置
LeetCode editor 配置

CodeFileName:
```java
P$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
```

Codetemplate:
```java
${question.content}

//Java：${question.title}

package com.vika.autumn.leetcode.editor.cn;

public class P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution = new P$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        // TO TEST
    }
    ${question.code}
}
```

## 常见问题

### 编译器语言版本

- Build -> Compiler -> Java Compiler
- Project Structure

### MapStruct 注解不识别

Build -> Compiler -> Annotation Processors

