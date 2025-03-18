package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启注解方式的事务管理
@EnableScheduling //开启任务调度
@SpringBootApplication
public class HouseKeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseKeepingApplication.class, args);
    }

}
