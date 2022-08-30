package com.zjut.example;

import com.zjut.server.RpcService;
import org.springframework.stereotype.Component;

@RpcService(interfaceName =ServerImp.class)
@Component
public class ServerImp implements TestServer {
    @Override
    public void test(String s) {
        System.out.println("Yes!");
        System.out.println(s);
    }
}
