package com.zjut;

import com.zjut.zookeeper.ZookeeperServiceDiscovery;
import com.zjut.zookeeper.ZookeeperServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RpcRegisterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RpcRegisterApplication.class, args);
        ZookeeperServiceRegistry bean = run.getBean(ZookeeperServiceRegistry.class);

        bean.register("com.zjut.server.TestServer","127.0.0.1:8000");
        ZookeeperServiceDiscovery bean1 = run.getBean(ZookeeperServiceDiscovery.class);
        System.out.println(bean1.discovery("com.zjut.server.TestServer"));

    }

}
