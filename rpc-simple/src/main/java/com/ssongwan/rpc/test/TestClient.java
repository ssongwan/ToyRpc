package com.ssongwan.rpc.test;

import com.ssongwan.rpc.api.HelloObject;
import com.ssongwan.rpc.api.HelloService;
import com.ssongwan.rpc.transport.RpcClientProxy;

public class TestClient {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String result = helloService.hello(object);
        System.out.println(result);
    }
}
