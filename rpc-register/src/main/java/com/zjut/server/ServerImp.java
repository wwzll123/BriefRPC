package com.zjut.server;


public class ServerImp implements TestServer{
    @Override
    public void test(String s) {
        System.out.println("Yes!");
        System.out.println(s);
    }
}
