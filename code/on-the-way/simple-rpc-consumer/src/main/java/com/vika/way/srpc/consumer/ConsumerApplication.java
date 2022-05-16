package com.vika.way.srpc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/

@SpringBootApplication(scanBasePackages = {"com.vika.way.srpc.consumer"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
