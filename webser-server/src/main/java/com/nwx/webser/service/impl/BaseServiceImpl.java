package com.nwx.webser.service.impl;

import com.nwx.webser.service.BaseService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @version : V1.0
 * @Description:
 * @Auther: Neil
 * @Date: 2019/4/9 10:31
 */
@Service(version = "1.0")
public class BaseServiceImpl implements BaseService {
    @Override
    public String test(String serviceId) {
        return "接口"+serviceId+"返回值：hello dubbo";
    }
}
