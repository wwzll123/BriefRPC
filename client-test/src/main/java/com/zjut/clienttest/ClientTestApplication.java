package com.zjut.clienttest;

import com.zjut.rpcclient.RpcProxy;
import com.zjut.serverinterface.TestServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(scanBasePackages ={"com.zjut.rpcclient","com.zjut.zookeeper","com.zjut.entity","com.zjut.serialization"})
public class ClientTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ClientTestApplication.class, args);
        RpcProxy bean = run.getBean(RpcProxy.class);
        TestServer proxy = bean.create(TestServer.class);
        String test = proxy.test("hello!");
        System.out.println(test);
    }

}
