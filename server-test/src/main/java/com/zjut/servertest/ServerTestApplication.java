package com.zjut.servertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//这里是服务端，只需要注册服务，实现服务，这些都是在容器加载的时候自动完成的
@SpringBootApplication(scanBasePackages ={"com.zjut.server","com.zjut.zookeeper","com.zjut.entity","com.zjut.serialization","com.zjut.servertest"})
public class ServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerTestApplication.class, args);
    }

}
