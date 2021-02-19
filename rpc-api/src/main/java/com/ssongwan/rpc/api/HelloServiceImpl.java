package com.ssongwan.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService{

    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject helloObject) {
        log.info("接收到：{}", helloObject.getMessage());
        return "id = " + helloObject.getId();
    }

}
