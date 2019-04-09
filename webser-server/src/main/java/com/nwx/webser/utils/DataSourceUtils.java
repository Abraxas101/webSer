package com.nwx.webser.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import com.nwx.webser.pojo.Database;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @version : V1.0
 * @Description: https://blog.csdn.net/coder_zyz/article/details/81043415
 * @Auther: Neil
 * @Date: 2019/4/9 11:34
 */
public class DataSourceUtils {

    /**
     * 获取当前连接池信息
     * @param dsName
     * @return
     */
    public static DruidDataSource getDataSource(String dsName){
        DruidDataSource ds = null ;
        for(DruidDataSource datasource : DruidDataSourceStatManager.getDruidDataSourceInstances()){
            if(dsName.equals(datasource.getName())){
                ds = datasource ;
                break;
            }
        }
        return ds ;
    }

    /**
     * 创建数据库连接池
     * @param database
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public static DruidDataSource createDataSource(Database database) throws SQLException, NoSuchAlgorithmException {

        DruidDataSource dataSource = null ;
        String dsName = database.getDsId() ;
        if((dataSource = getDataSource(dsName))==null){
                dataSource = new DruidDataSource();
                dataSource.setName(dsName) ;
                dataSource.setUrl(database.getDsUrl());
                dataSource.setDriverClassName(database.getDriveClass());
                dataSource.setUsername(database.getUserName());
                dataSource.setPassword(database.getPassword());

                dataSource.setInitialSize(5);
                dataSource.setMinIdle(5);
                dataSource.setMaxActive(5);
                dataSource.setMaxWait(6000) ;
                dataSource.setMinEvictableIdleTimeMillis(300000) ;
                dataSource.setRemoveAbandoned(false);//超过时间限制是否回收
                dataSource.setRemoveAbandonedTimeout(180);//超过时间限制多长
                dataSource.setTimeBetweenEvictionRunsMillis(60000);//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
                dataSource.setTestWhileIdle(true);
                dataSource.setTestOnBorrow(false) ;
                dataSource.setTestOnReturn(false) ;
                dataSource.setPoolPreparedStatements(true) ;
                dataSource.setMaxPoolPreparedStatementPerConnectionSize(20) ;
                dataSource.setTimeBetweenLogStatsMillis(3600000) ;
                dataSource.addConnectionProperty("remarksReporting", "true");

                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();

                statement.execute(database.getValidationQuery());

                statement.close();
                connection.close();
        }
        return dataSource;

    }
    /**
     * 关闭数据库连接池
     * @param dsName
     */
    public static void closeDataSource(String dsName){
        getDataSource(dsName).close() ;
    }
}
