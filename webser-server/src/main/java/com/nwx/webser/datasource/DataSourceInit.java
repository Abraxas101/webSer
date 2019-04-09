package com.nwx.webser.datasource;

import com.nwx.webser.pojo.Database;
import com.nwx.webser.utils.DataSourceUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @version : V1.0
 * @Description: 接口数据源初始化
 * @Auther: Neil
 * @Date: 2019/4/9 11:17
 */
@Component
public class DataSourceInit implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

        Database database = new Database();

        database.setDsId("1");
        database.setDriveClass("com.mysql.jdbc.Driver");
        database.setDsUrl("jdbc:mysql://49.74.219.76:3306/uni-db?useUnicode=true&characterEncoding=utf-8&useSSL=true");
        database.setPassword("tdxxnewyear2016");
        database.setUserName("root");
        database.setValidationQuery("select 'X'");

        DataSourceUtils.createDataSource(database);

        System.out.println("项目启动啦。。。。。");
    }
}
