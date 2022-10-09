package DataSource.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties pro=new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
