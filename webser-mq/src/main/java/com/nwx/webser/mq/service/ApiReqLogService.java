package com.nwx.webser.mq.service;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @version : V1.0
 * @Description: api服务请求日志
 * @Auther: Neil
 * @Date: 2019/4/9 13:32
 */
@EnableJms
@Component
public class ApiReqLogService {

    @JmsListener(destination = "queue01")
    public void insertLog(String msg) {
        System.out.println("接收到的消息:");
        System.out.println(msg);
    }
}
