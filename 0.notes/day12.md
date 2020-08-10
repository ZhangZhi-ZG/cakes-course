# day12
> dubbo

---

## 1.今日大纲

#### 1.1 Dubbo前置知识

#### 1.2 Dubbo基础

#### 1.3 Dubbo配置

#### 1.4 SpringBoot整合

---

## 2.Dubbo前置知识

#### 2.0 发展过程
* 

#### 2.1 分布式
[分布式系统(百度百科)](https://baike.baidu.com/item/%E5%88%86%E5%B8%83%E5%BC%8F%E7%B3%BB%E7%BB%9F/4905336)

#### 2.2 RPC
[RPC(百度百科)](https://baike.baidu.com/item/%E8%BF%9C%E7%A8%8B%E8%BF%87%E7%A8%8B%E8%B0%83%E7%94%A8/7854346)

---

## 3.Dubbo基础

#### 3.1 Dubbo解决了哪些问题
> Dubbo优点

#### 3.2 Dubbo架构思路
[Dubbo架构](http://dubbo.apache.org/zh-cn/docs/user/preface/architecture.html)

#### 3.3 Dubbo环境搭建
##### 3.3.1 搭建基于Zookeeper的注册中心
* zookeeper下载

[zookeeper下载](https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.4.14/)

* zookeeper安装

* 查看目录结构

* 基本操作命令

##### 3.3.2 dubbo依赖
```groovy
compile('com.alibaba:dubbo:2.6.6')
compile('io.netty:netty-all:4.1.34.Final')
compile('org.apache.zookeeper:zookeeper:3.4.14')
compile('org.apache.curator:curator-framework:2.13.0')
compile('org.apache.curator:curator-recipes:2.13.0')
```

##### 3.3.3 hello dubbo
* iface
    - 打包至本地仓库
```groovy
def localMavenRepo = 'file://' + new File(System.getProperty('user.home'), '.m2/repository').absolutePath
uploadArchives {
    repositories {
        mavenDeployer {
            repository(url: localMavenRepo)
            pom.project {
                name = project.name
                packaging = 'jar'
                description = 'description'
            }
        }
    }
}

```
* provider
* consumer

##### 3.3.3 看一个现象
* 先启动consumer

---

## 4.Dubbo配置

#### 4.1 check false
[启动时检查](http://dubbo.apache.org/zh-cn/docs/user/demos/preflight-check.html)

#### 4.2 timeout
[超时配置](http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-reference.html)

#### 4.3 retries
[超时配置](http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-reference.html)

#### 4.4 直连

---

## 5.SpringBoot整合

### 5.1 依赖starter
* compile('com.alibaba.spring.boot:dubbo-spring-boot-starter:2.0.0')

#### 5.2 application.yml
##### provider
```yml
dubbo:
  application:
    name: dubbo-springboot-provider
  registry:
    address: 127.0.0.1:2181
    protocol: zookeeper
  protocol:
    name: dubbo
    port: 20880
```

##### consumer
```yml
dubbo:
  application:
    name: dubbo-springboot-consumer
  registry:
    address: zookeeper://127.0.0.1:2181
```

---

## 6.其他

#### qos配置
##### dubbo.properties
* dubbo.application.qos.enable=false

---

## 总结

---

## 参考资料

[dubbo官网](http://dubbo.io/)
