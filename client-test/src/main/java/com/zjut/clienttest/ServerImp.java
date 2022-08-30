package com.zjut.clienttest;

import com.zjut.serverinterface.TestServer;
import org.springframework.stereotype.Component;

@Component
public class ServerImp implements TestServer {
    @Override
    public String test(String s) {
        System.out.println("here is method in client");
        System.out.println("parameter: "+s);
        return "client";
    }
}
