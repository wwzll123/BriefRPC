package com.zjut.zookeeper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ZookeeperServiceDiscovery {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperServiceRegistry.class);

    @Value("${register.address}")
    private String zkAddress;

    String ZK_REGISTRY_PATH = "/registry";



    @Autowired
    private Config config;

    //服务调用
    public String discovery(String serviceName) {
        ZkClient zkClient = new ZkClient(zkAddress,config.ZK_SESSION_TIMEOUT, config.ZK_CONNECTION_TIMEOUT);
        LOGGER.info("connect zookeeper");

        try {
            // 根据 serviceName 查找 service 节点
            String servicePath = ZK_REGISTRY_PATH + "/" + serviceName;
            if (!zkClient.exists(servicePath)) {
                throw new RuntimeException("can not find any service node on path: "+servicePath);
            }
            // 查找 address 节点
            List<String> addressList = zkClient.getChildren(servicePath);
            if (CollectionUtils.isEmpty(addressList)) {
                throw new RuntimeException(String.format("can not find any address node on path: %s", servicePath));
            }
            String address;
            int size = addressList.size();
            if (size == 1) {
                // 如果只有一个 address 节点，则直接获取该地址
                address = addressList.get(0);
                LOGGER.info("get only address node: {}", address);
            }
            else {
                // 若存在多个address 节点，则通过负载均衡策略获取一个地址（这里就选择了最简单的随机获取）
                address = addressList.get(ThreadLocalRandom.current().nextInt(size));
                LOGGER.info("get random address node: {}", address);
            }
            // 读取 address 节点的内容（服务地址）
            String addressPath = servicePath + "/" + address;
            return zkClient.readData(addressPath);
        } finally {
            zkClient.close();
        }
    }


}
