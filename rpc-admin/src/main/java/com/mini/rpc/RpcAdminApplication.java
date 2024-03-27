package com.mini.rpc;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class RpcAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcAdminApplication.class, args);
    }
}