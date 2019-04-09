package com.nwx.webser.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nwx.webser.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * @Author Neil
     * @Description sql脚本API
     * @Date 2019/4/9 10:23
     * @Param [serviceId 服务ID]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/sqlrest/{serviceId}")
    public String sqlrest(@PathVariable String serviceId){

        String str = baseService.test(serviceId);

        return str;
    }
}
