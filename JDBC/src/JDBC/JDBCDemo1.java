package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaWeb_jdbc", "root", "123456");
        String sql="update account set balance=50000 where id=1";
        Statement stmt=connection.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        connection.close();
    }
}
