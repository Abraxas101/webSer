package com.nwx.webser.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nwx.webser.service.BaseService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

/**
 * @version : V1.0
 * @Description: api服务请求
 * @Auther: Neil
 * @Date: 2019/4/9 10:13
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Reference(version = "1.0")
    private BaseService baseService;

    @Autowired
    private JmsMessagingTemplate template;

    /**
     * @Author Neil
     * @Description sql脚本API
     * @Date 2019/4/9 10:23
     * @Param [serviceId 服务ID]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/sqlrest/{serviceId}")
    public String sqlrest(@PathVariable String serviceId, HttpServletRequest request){

        String type = request.getParameter("type")==null?"json":request.getParameter("type");

        Destination destination = new ActiveMQQueue("queue01");
        String message = "我是消息内容, " + serviceId;
        template.convertAndSend(destination, message);

        String str = baseService.test(serviceId);

        return str;
    }
}
