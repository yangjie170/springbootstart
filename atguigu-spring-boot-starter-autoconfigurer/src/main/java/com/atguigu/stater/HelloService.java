package com.atguigu.stater;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloAtguigu(String name){
        return helloProperties.getPrefix()+ name + ""+helloProperties.getSuffix();
    }
}
