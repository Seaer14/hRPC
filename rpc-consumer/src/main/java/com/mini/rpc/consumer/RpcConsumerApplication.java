package com.mini.rpc.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.mini.rpc.mapper")
public class RpcConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcConsumerApplication.class, args);
    }
}
