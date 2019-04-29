package com.slming;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <br/>
 * <p> Project: springboot-dubbo-parent </p>
 * <p> Author: Leiming She </p>
 * <p> Date: 2019-04-29 13:33 </p>
 *
 * @author itslm
 */
@EnableDubbo
@SpringBootApplication
public class AppOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppOrderApplication.class, args);
    }
}
