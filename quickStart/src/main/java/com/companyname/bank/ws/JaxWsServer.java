package com.companyname.bank.ws;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class JaxWsServer {

    public static void main(String[] args) {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("http://localhost:8080/ws/soap/hello");
        factoryBean.setServiceClass(HelloService.class);
        factoryBean.setServiceBean(new HelloServiceImpl());
        factoryBean.create();
        System.out.println("soap ws is published.");
    }
}
