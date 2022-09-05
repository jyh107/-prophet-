package cn.docase.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 是一个工具类：用于通过druid连接完成连接操作
 */
public class DruidUtil {
    /*
    数据源对象：java.sql.DataSource接口对象，表示数据源，可以直接理为连接池
    所有的连接池都会有一个数据源这个接口。druid实现这个数据源就是：DruidDataSource
     */
    //1定义一个静态数据源对象
    private static DataSource dataSource;
    //2通过一个static代码块完成加载
    static {
        try {
            //3创建一个Properties对象
            Properties properties=new Properties();
            //4将配置文件转换字节输入流
            InputStream is=DruidUtil.class.getClassLoader().getResourceAsStream("application.properties");
            //5使用properties对象加载is
            properties.load(is);
            //6用druid底层方式实现（工厂设计模式）去加载配置文件，创建数据源对象
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //7定义一个方法用于返回数据源
    public static DataSource getDataSource(){
        return dataSource;
    }
}
