package com.nwx.webser.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.nwx.webser.service.BaseService;
import com.alibaba.dubbo.config.annotation.Service;
import com.nwx.webser.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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


        try {
            DruidDataSource druiddatasource= DataSourceUtils.getDataSource("1");
            Connection connection = druiddatasource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute("select 'x'");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "接口"+serviceId+"返回值：hello dubbo";
    }
}
