package com.zjut.servertest;

import com.zjut.server.RpcService;
import com.zjut.serverinterface.TestServer;
import org.springframework.stereotype.Component;

@RpcService(interfaceName =TestServer.class)
@Component
public class ServerImp implements TestServer {
    @Override
    public String test(String s) {
        System.out.println("Here is method in Server, parameter:");
        System.out.println(s);
        return "Server";
    }
}
