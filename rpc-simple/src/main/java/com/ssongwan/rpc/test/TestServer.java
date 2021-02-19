package com.ssongwan.rpc.test;

import com.ssongwan.rpc.api.HelloService;
import com.ssongwan.rpc.api.HelloServiceImpl;
import com.ssongwan.rpc.transport.RpcServer;

public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }
}
