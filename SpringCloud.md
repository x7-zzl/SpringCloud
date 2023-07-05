# 微服务导学

## 微服务技术栈

![image-20230629233516607](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230629233516607.png)

![image-20230629233532536](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230629233532536.png)

![image-20230629234125022](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230629234125022.png)

![image-20230629234647378](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230629234647378.png)

![image-20230629235517790](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230629235517790.png)

![image-20230701154132453](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701154132453.png)

![image-20230701154304970](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701154304970.png)

## 认识微服务

![image-20230701163405327](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701163405327.png)

![image-20230701171250498](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701171250498.png)

# 版本对应问题

Spingboot  2.3.4.RELEASE

SpringCloud    Hoxton.SR10

Eureka  不需要    [2.2.5.RELEASE]

nacos     2.2.5.RELEASE









 <mysql.version>8.0.25</mysql.version>
 <mybatis.version>2.3.0</mybatis.version>







# SpringCloud

![image-20230701171620556](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701171620556.png)

### springcloud和springboot对应版本

![image-20230701171814232](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701171814232.png)

### 远程调用

cloud-pom

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.4.RELEASE</version>
        <relativePath/>
    </parent>

<!-- 继承此处   -->
    <groupId>com.zzl</groupId>
    <artifactId>SpringCloud</artifactId>
    <version>0.0.1-SNAPSHOT</version>


    <modules>
        <module>user-service</module>
        <module>order-service</module>
    </modules>

    <packaging>pom</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>11</java.version>
        <spring-cloud.version>Hoxton.SR10</spring-cloud.version>
        <mysql.version>8.0.25</mysql.version>
        <mybatis.version>2.3.0</mybatis.version>
    </properties>
    <dependencyManagement>
        <dependencies>
            <!-- springCloud -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!-- mysql驱动 -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>

            <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>2.3.0</version>
            </dependency>

        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

user

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.zzl</groupId>
        <artifactId>SpringCloud</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <groupId>cn.itcast</groupId>
    <artifactId>user-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>user-service</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
    </dependencies>

    <build>
        <finalName>app</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

order

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>


    <parent>
        <groupId>com.zzl</groupId>
        <artifactId>SpringCloud</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <groupId>cn.itcast</groupId>
    <artifactId>order-service</artifactId>


    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

服务间进行远程调用，经过一系列分析，用户处想获得订单信息，可以使用Ajax发送请求就会返回相应的结果数据；

而又不同服务之间，可以使用Java代码中发送类似于Ajax请求的方式可以解决我问题，

![image-20230701191303182](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701191303182.png)

![image-20230701191900697](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701191900697.png)

### 提供者和消费者

![image-20230701193611315](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701193611315.png)

# Eureka注册中心

### Eureka作用

![image-20230701205319123](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701205319123.png)

![image-20230701205351009](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701205351009.png)

### 搭建Eureka

![image-20230701205725572](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701205725572.png)

### Eureka服务注册

1.导入pom

```java
<!--        eureka客户端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <!--            <version>2.2.5.RELEASE</version>-->
        </dependency>
```

2.application.yml

```
spring:
  application:
    #    user服务名称
    name: userservice


#作服务注册才配置的信息
eureka:
  client:
    service-url: #eureka地址名称
      #      多个的话用逗号隔开
      defaultZone: http://127.0.0.1:10086/eureka

```

查看配置成功信息

![image-20230701224425939](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230701224425939.png)

多实例端口，IDEA开启两个服务端口并配置信息；

![image-20230702132424279](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230702132424279.png)

![image-20230702132521045](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230702132521045.png)

### Eureka服务发现

![image-20230702132632418](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230702132632418.png)

![image-20230702133856802](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230702133856802.png)

# Ribbon负载均衡

![image-20230702163839554](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230702163839554.png)

![image-20230702165042700](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230702165042700.png)



![image-20230703151200174](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703151200174.png)

![image-20230703151251017](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703151251017.png)

![image-20230703152436649](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703152436649.png)

上述第一种方式是作用范围是全局的，所有orderApplication中的微服务都用这个规则;

第二种方式是为orderApplication中的某一种微服务设置规则；

![image-20230703153107453](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703153107453.png)

![image-20230703154021327](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703154021327.png)

# Nacos注册中心

## 	Nacos注册步骤

==**启动Nacos服务：**==

==**startup.cmd -m standalone**==

![image-20230703162427901](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703162427901.png)

![image-20230703162437911](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703162437911.png)

![image-20230703190659188](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703190659188.png)

## Nacos服务分级

服务-》集群-》实例

![image-20230703205845978](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703205845978.png)

![image-20230703210324321](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703210324321.png)

### Nacos配置集群

![image-20230703210840005](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703210840005.png)

![image-20230703220830438](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703220830438.png)

![image-20230703221251792](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703221251792.png)

负载均衡策略

![image-20230703222221458](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703222221458.png)



根据权重负载均衡

![image-20230703222444645](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703222444645.png)

权重的作用：灰度升级，把一个服务器实例的权重设置为0，然后请求就不会从这台服务器过，这时进行迭代升级，放一些用户请求进行调试观察是否成功；循环往复，一直这样就可以实现白天偷偷升级服务器，不用加班-^^-

![image-20230703222933126](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703222933126.png)

## 环境隔离-namespace

![image-20230703223339230](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703223339230.png)



![image-20230703231653244](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703231653244.png)

![image-20230703231707400](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703231707400.png)

![image-20230703231718031](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703231718031.png)

![image-20230703231730408](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703231730408.png)

![image-20230703231736799](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703231736799.png)

![image-20230703231747221](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703231747221.png)

nacos原理

![image-20230703232846593](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703232846593.png)

![image-20230703233208469](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230703233208469.png)

## Nacos配置管理

### 统一配置管理

![image-20230705142507361](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705142507361.png)

![image-20230705144028342](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705144028342.png)

![image-20230705144503543](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705144503543.png)

![image-20230705144536643](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705144536643.png)

![image-20230705150629463](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705150629463.png)

![image-20230705150654753](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705150654753.png)



### 配置热更新

![image-20230705150933413](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705150933413.png)

![image-20230705151301685](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705151301685.png)

![image-20230705152435703](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705152435703.png)

推荐使用第二种方式，无须结合@RefreshScope完成热更新；

### 多环境配置共享

![image-20230705154505219](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705154505219.png)

![image-20230705154514769](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705154514769.png)

## 集群搭建

![image-20230705154847718](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705154847718.png)

![image-20230705155057566](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705155057566.png)

![image-20230705160131593](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705160131593.png)

# Feign-http客户端

## Feign基本使用

![image-20230705160629069](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705160629069.png)

![image-20230705160615675](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705160615675.png)

![image-20230705181236773](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705181236773.png)



![image-20230705170505934](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705170505934.png)

![image-20230705185212858](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705185212858.png)

![image-20230705185136135](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705185136135.png)

## 自定义配置

![image-20230705185300619](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705185300619.png)

![image-20230705185607842](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705185607842.png)

![image-20230705190923532](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705190923532.png)


![image-20230705191323340](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705191323340.png)

## Feign性能优化

![image-20230705205532992](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705205532992.png)

![image-20230705205651799](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705205651799.png)

![image-20230705210236999](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705210236999.png)

## Feign的最佳实践

![image-20230705210654238](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705210654238.png)

![image-20230705211115162](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705211115162.png)

![image-20230705211206348](D:%5C%E6%A1%8C%E9%9D%A2%5CNote%5Ctypora_img%5Cimage-20230705211206348.png)

