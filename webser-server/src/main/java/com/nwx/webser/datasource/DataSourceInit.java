package com.nwx.webser.datasource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @version : V1.0
 * @Description: 接口数据源初始化
 * @Auther: Neil
 * @Date: 2019/4/9 11:17
 */

public class DataSourceInit implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("项目启动啦。。。。。");
    }
}
