package com.zjut.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZookeeperServiceRegistry {

    // 在该节点下存放所有的服务节点
    String ZK_REGISTRY_PATH = "/registry";

    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperServiceRegistry.class);

    @Autowired
    @Lazy
    private ZkClient zkClient;

    //服务注册
    public void register(String serviceName, String serviceAddress) {
        // 创建 registry 持久节点，该节点下存放所有的 service 节点
        String registryPath = ZK_REGISTRY_PATH;
        if (!zkClient.exists(registryPath)) {
            zkClient.createPersistent(registryPath);
            LOGGER.info("create registry node: {}", registryPath);
        }
        // 在 registry 节点下创建 service 持久节点，存放服务名称
        String servicePath = registryPath + "/" + serviceName;
        if (!zkClient.exists(servicePath)) {
            zkClient.createPersistent(servicePath);
            LOGGER.info("create service node: {}", servicePath);
        }
        // 在 service 节点下创建 address 临时节点,存放服务地址
        String addressPath = servicePath + "/address-";
        String addressNode = zkClient.createEphemeralSequential(addressPath, serviceAddress);
        LOGGER.info("create address node: {}", addressNode);
    }

}
