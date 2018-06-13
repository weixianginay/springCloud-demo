# SpringCloud-Demo

## 背景
根据公司内部技术架构需求，期望以后能在现有的技术框架下，平滑的扩展出分布式架构，方便搭建分布式项目，运维简单的维护分布式部署。
通过一段时间的学习，根据现有项目框架（springboot）,初步决定采用springcloud，暂时不考虑dubbo的方案。
在项目整合springcloud中，发现springcloud侵入性很低，非常易于项目框架升级，在技术层面上暂时没有发现问题，待公司后期敲定升级时，嵌入代码。

为方便日后工作，故整理出一份纯净的demo。
 
## 版本：
* IntelliJ IDEA 2017.3.4 x64
* SpringBoot  1.5.13.RELEASE
* SpringBootAdmin  1.5.7
* Springcloud  Edgware.SR3
* JDK 1.8

## 目前项目情况
* eureka 高可用
* provider 注册服务
* feign 消费服务
* zuul 网关
* admin 管理界面-邮件推送



# 路径地址 linux服务器IP 172.20.2.167
 
## eureka高可用
* eureka1:  172.20.2.167:8088
* eureka2:  172.20.2.167:8089

### 启动jar
nohup java -jar eureka-server-0.0.1-SNAPSHOT.jar & <br />
nohup java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka2 &

### 查看jar服务
ps aux|grep eureka-server-0.0.1-SNAPSHOT.jar

### 关闭进程
kill -9 28550


## 服务提供者
provider1:  172.20.2.167:8065,172.20.2.167:8067<br />
provider2:  172.20.2.167:8066<br />

### 启动jar
nohup java -jar provider-0.0.1-SNAPSHOT.jar & <br />
nohup java -jar provider-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev2 & <br />
nohup java -jar provider-0.0.1-SNAPSHOT.jar --server.port=8067 & <br />

### url
http://172.20.2.167:8067/hello/get<br />
http://172.20.2.167:8067/hello/post (post)<br />
http://172.20.2.167:8067/hello/reset<br />

## 服务消费者
cosumer1: 172.20.2.167:8070<br />

### 启动jar
nohup java -jar fbn-feign-0.0.1-SNAPSHOT.jar &<br />

### url
http://172.20.2.167:8070/feign/get<br />

## 网关
zuul: 172.20.2.167:8050<br />

### 启动jar
nohup java -jar fbn-zuul-0.0.1-SNAPSHOT.jar &<br />

### url 
http://172.20.2.167:8050/c/feign/get<br />
http://172.20.2.167:8050/p/hello/get<br />

## 监控界面
admin:172.20.2.167:8030<br />
### 启动jar
nohup java -jar fbn-admin-0.0.1-SNAPSHOT.jar &<br />
