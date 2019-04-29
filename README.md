目录

一、版本及说明

二、项目结构介绍

三、整合开始

1、创建springboot-dubbo-paren父工程（pom）

2、创建springboot-dubbo-public-api-service公共Api接口工程（pom）

3、创建springboot-dubbo-public-api-member-service会员服务接口工程（jar）

4、创建springboot-dubbo-api-member-service-impl会员服务实现工程（jar）

5、创建springboot-dubbo-order-web订单工程（jar）,消费者角色，用于调用会员服务

四、启动项目

一、版本及说明
SpringBoot：2.1.4.RELEASE

ZooKeeper：3.4.6

Dubbo：0.2.0（dubbo-spring-boot-starter）

本教程采用 IDEA + Mavem 搭建，现在网上 SpringBoot整合Dubbo的教程非常之多，如有雷同还请见谅。

二、项目结构介绍


三、整合开始
1、创建springboot-dubbo-paren父工程（pom）
1、创建完成后删除 src 目录

2、父工程pom依赖如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.4.RELEASE</version>
        <relativePath/>
    </parent>

    <groupId>com.slming</groupId>
    <artifactId>springboot-dubbo-parent</artifactId>
    <packaging>pom</packaging>

    <version>1.0-SNAPSHOT</version>

    <modules>
        <module>springboot-dubbo-public-api-service</module>
        <module>springboot-dubbo-api-member-service-impl</module>
        <module>springboot-dubbo-order-web</module>
    </modules>

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.Encoding>UTF-8</project.reporting.Encoding>
    </properties>

    <dependencies>
        <!-- Dubbo -->
        <dependency>
            <groupId>com.alibaba.boot</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>0.2.0</version>
        </dependency>

        <!-- Zookeeper -->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.6</version>
            <type>pom</type>
        </dependency>

        <!-- Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
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
2、创建springboot-dubbo-public-api-service公共Api接口工程（pom）
1、创建完成后删除 src 目录

2、公共Api接口工程pom依赖如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- 继承自父工程 -->
    <parent>
        <artifactId>springboot-dubbo-parent</artifactId>
        <groupId>com.slming</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <packaging>pom</packaging>
    
    <modules>
        <module>springboot-dubbo-public-api-member-service</module>
    </modules>

    <artifactId>springboot-dubbo-public-api-service</artifactId>

</project>
3、创建springboot-dubbo-public-api-member-service会员服务接口工程（jar）
注意：该工程为公共Api接口工程（springboot-dubbo-public-api-service）的子工程，右击 公共Api接口工程  依次选择 “New”--->"Module" 

1、会员服务接口工程pom依赖如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- 父工程为公共API接口工程 -->
    <parent>
        <artifactId>springboot-dubbo-public-api-service</artifactId>
        <groupId>com.slming</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>
    <packaging>jar</packaging>

    <artifactId>springboot-dubbo-public-api-member-service</artifactId>

</project>
2、创建会员服务接口：com.slming.api.memeber.IMemberService

package com.slming.api.memeber;

/**
 * @author itslm
 */
public interface IMemberService {

    /**
     * 获取会员
     * <br/>
     * <p>Author: Leiming She</p>
     * <p>Date: 2019-04-29 10:05:36</p>
     *
     * @param username 用户名
     * @return java.lang.String
     */
    String getMember(String username);
}
4、创建springboot-dubbo-api-member-service-impl会员服务实现工程（jar）
注意：该工程为父工程（springboot-dubbo-paren）下的子工程

1、会员服务实现工程pom依赖如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- 继承自父工程 -->
    <parent>
        <artifactId>springboot-dubbo-parent</artifactId>
        <groupId>com.slming</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>

    <packaging>jar</packaging>

    <artifactId>springboot-dubbo-api-member-service-impl</artifactId>

    <dependencies>
        <dependency>
            <artifactId>springboot-dubbo-public-api-member-service</artifactId>
            <groupId>com.slming</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

</project>
2、创建会员服务实现类：com.slming.api.memeber.impl.MemberServiceImpl

注意：该类的 @Service 注解为 com.alibaba.dubbo.config.annotation.Service 包下的，不要导错包哦~

package com.slming.api.memeber.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.slming.api.memeber.IMemberService;

/**
 * @author itslm
 */
@Service
public class MemberServiceImpl implements IMemberService {

    /**
     * 获取会员
     * <br/>
     * <p>Author: Leiming She</p>
     * <p>Date: 2019-04-29 10:05:36</p>
     *
     * @param username 用户名
     * @return java.lang.String
     */
    @Override
    public String getMember(String username) {
        return "Dubbo：" + username;
    }
}
3、创建application.yml文件：

server:
  port: 8080
dubbo:
  application:
    name: member
  protocol:
    port: 20880
    name: dubbo
  registry:
    address: zookeeper://127.0.0.1:2181
4、创建应用启动类：com.slming.AppMemberApplication

注意：需要加上 @EnableDubbo 注解，开启Dubbo支持

package com.slming;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author itslm
 */
@SpringBootApplication
@EnableDubbo
public class AppMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppMemberApplication.class, args);
    }
}
5、创建springboot-dubbo-order-web订单工程（jar）,消费者角色，用于调用会员服务
注意：该工程为父工程（springboot-dubbo-paren）下的子工程

1、订单工程pom依赖如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <parent>
        <artifactId>springboot-dubbo-parent</artifactId>
        <groupId>com.slming</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>

    <packaging>jar</packaging>

    <artifactId>springboot-dubbo-order-web</artifactId>

    <dependencies>
        <dependency>
            <artifactId>springboot-dubbo-public-api-member-service</artifactId>
            <groupId>com.slming</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
2、创建订单访问类：com.slming.order.controller.OrderController

注意：此处不再使用 @Autoware 进行注入，而使用com.alibaba.dubbo.config.annotation.Reference包下的@Reference 注入

package com.slming.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.slming.api.memeber.IMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itslm
 */
@RestController
public class OrderController {

    @Reference
    private IMemberService memberService;

    @GetMapping("getMember/{username}")
    public String getMember(@PathVariable("username") String username){
        return memberService.getMember(username);
    }
}
3、创建application.yml文件：

server:
  port: 8082
dubbo:
  application:
    name: order
  registry:
    address: zookeeper://127.0.0.1:2181
  consumer:
    timeout: 5000
4、创建应用启动类：com.slming.AppOrderApplication

注意：需要加上 @EnableDubbo 注解，开启Dubbo支持

package com.slming;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author itslm
 */
@EnableDubbo
@SpringBootApplication
public class AppOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppOrderApplication.class, args);
    }
}
四、启动项目
1、启动zookeeper注册中心

2、启动会员服务实现项目（springboot-dubbo-api-member-service-impl）

3、启动订单项目（springboot-dubbo-order-web）

4，打开浏览器输入：localhost:8082/getMember/itslm      回车，显示如下页面即整合成功！



