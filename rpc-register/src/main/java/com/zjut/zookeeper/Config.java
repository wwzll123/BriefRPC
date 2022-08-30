package com.zjut.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Config {

    //注册中心地址
    @Value("${register.address}")
    public String add;

    @Value("${register.ZK_SESSION_TIMEOUT}")
    public int ZK_SESSION_TIMEOUT;

    @Value("${register.ZK_CONNECTION_TIMEOUT}")
    public int ZK_CONNECTION_TIMEOUT;

    @Bean
    public ZkClient getZkClient(){
        return new ZkClient(add,ZK_SESSION_TIMEOUT,ZK_CONNECTION_TIMEOUT);
    }

}
