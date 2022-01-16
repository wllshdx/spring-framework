# 踩坑记录

## 配置gradle的阿里云镜像

gradle配置阿里云镜像：

+ 直接在自己的sdk中文件夹的gradle的中新建init.d文件夹，新建init.gradle文件
  + 文件内容如下：

```shell
buildscript {
	repositories {
		maven { url 'https://maven.aliyun.com/repository/gradle-plugin' }
		maven { url 'https://plugins.gradle.org/m2/' }
	}
}
allprojects {
    repositories {
        def ALIYUN_REPOSITORY_URL = 'https://maven.aliyun.com/repository/public'
		def ALIYUN_JCENTER_URL = 'https://maven.aliyun.com/nexus/content/repositories/jcenter'
        all { ArtifactRepository repo ->
            if(repo instanceof MavenArtifactRepository){
                def url = repo.url.toString()
                if (url.startsWith('https://repo1.maven.org/maven2')) {
                    project.logger.lifecycle "Repository ${repo.url} replaced by $ALIYUN_REPOSITORY_URL."
                    remove repo
                }
				if (url.startsWith('https://jcenter.bintray.com/')) {
                    project.logger.lifecycle "Repository ${repo.url} replaced by $ALIYUN_JCENTER_URL."
                    remove repo
                }
            }
        }
        maven {
			url ALIYUN_REPOSITORY_URL
			url ALIYUN_JCENTER_URL
		}
    }
}
```

## 2022-01-10

+ 因为不会使用gradle的踩坑
  + **当引入新模块时，要在新模块的build.gradle文件的dpendency中先run一下，java代码里才能引入相关模块**
  + gradle不允许循环依赖
+ 因为jdk不包含aspectJ的依赖，所以需要手动下载aspectJ的依赖， 并在电脑中`java -jar XXX.jar`安装
  + 相关教程：[spring-aspects源码编译 - 简书](https://www.jianshu.com/p/4c39a16c5764)
  + idea2021有坑，在java compiler里面是勾选不了ajc的，所以退而使用idea2020
    + 2022-01-16 确认不是重新建立jar包的索引的问题，是在模块内部的`build.gradle`文件中在`dependency`
      中需要引入`implementation('org.aspectj:aspectjrt:1.9.6')`
      + 然后进行在文件中构建一下
      + rebuild project
      + 最好再执行一次[File -> Invalid Cache/Restart]，重启idea
  + jar包已经放在项目中

## 2022-01-16

+ 如果报什么[cause EOF]，检查项目的gradle版本，是否跟项目需要的一致

## 网上看到的一些文章
