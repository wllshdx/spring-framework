# 踩坑记录

## 很久之前的踩坑

gradle配置项目的阿里云镜像

## 2022-01-10

+ 因为不会使用gradle的踩坑
  + **当引入新模块时，要在新模块的build.gradle文件的dpendency中先run一下，java代码里才能引入相关模块**
  + gradle不允许循环依赖
+ 因为jdk不包含aspectJ的依赖，所以需要手动下载aspectJ的依赖， 并在电脑中`java -jar XXX.jar`安装
  + 相关教程：[spring-aspects源码编译 - 简书](https://www.jianshu.com/p/4c39a16c5764)
  + idea2021有坑，在java compiler里面是勾选不了ajc的，所以退而使用idea2020
    + 最终能够勾选之后，耽误了两天还是不能重启
    + 最终发现是idea的问题，需要[File -> Invalid Cache/Restart]
  + jar包已经放在项目中

## 网上看到的一些文章
