package DataSource.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0demo1 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource=new ComboPooledDataSource();//数据库连接池对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
