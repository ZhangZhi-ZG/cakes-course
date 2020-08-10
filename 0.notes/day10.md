# day10
> mysql-schema-syncer,kafka

---

## 概述

#### 简介
* http://kafka.apache.org/
* kafka 《A distributed streaming platform》
* 基于zk的分布式(distributed)消息系统

#### 特点
* 高吞吐
* 高性能
* 实时
* 可靠

---

## kafka安装
> http://kafka.apache.org/downloads
> https://zookeeper.apache.org/releases.html

#### 版本选择
* kafka最新: kafka_2.13-2.5.0.tgz
* zk: Apache ZooKeeper 3.6.1

#### 安装部署(docker环境)
* 下载centos7.x镜像
    - docker search centos
        + 查找,选择<The official build of CentOS.>
    - docker pull centos:latest
        + 下载centos镜像
* 运行centos镜像
    - docker run -d -i --name kafka-centos -p 2181:2181 -p 9092:9092 -t <your image id> /bin/bash
        + 启动刚下载的 centos 镜像
        + -p 开启对外端口,外部可以访问,2181是zk端口,9092是kafka
        + /bin/bash 启动后确保centos可以后台运行,否则会启动就退出
* 进入centos容器
    - docker attach <container id>
* 下载安装包
    - wget https://mirror.bit.edu.cn/apache/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1-bin.tar.gz
    - wget https://mirror.bit.edu.cn/apache/kafka/2.5.0/kafka_2.13-2.5.0.tgz
* 安装jdk环境,并配置相关环境变量
* 安装zk
    - 解压
    - 配置
    - 启动
    - 测试
* 安装kafka
    - 解压
    - 配置(config/server.properties)
        + listeners=PLAINTEXT://<your host>:9092
        + advertised.listeners=PLAINTEXT://your.host.name:9092
        + zookeeper.connect=localhost:2181
    - 启动
        + 启动kafka broker
            * ./bin/kafka-server-start.sh ./config/server.properties &
        + 关闭kafka broker
            * ./bin/kafka-server-stop.sh
    - 测试
        + 创建topic
            * ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic hello-kafka
            * ./bin/kafka-topics.sh --list --zookeeper localhost:2181
        + 消费者监听
            * ./bin/kafka-console-consumer.sh --bootstrap-server 172.17.0.4:9092 --from-beginning --topic hello-kafka
        + 生产者生产
            * ./bin/kafka-console-producer.sh --broker-list localhost:2181 --topic hello-kafka

#### Mac安装
* 解压
* 配置
* 启动
* 测试

---

## Kafka基础

#### 基本概念
* Topic(主题): 逻辑概念，一般由1-n个partitions组成
* Partition: 实际消息存储单位
* Producer(生产者): 消息的生产方
* Consumer(消费者): 消息的消费方

---


## 今日总结

---

## 参考资料




