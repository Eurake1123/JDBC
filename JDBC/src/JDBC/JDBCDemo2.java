package JDBC;

import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection conn =null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaWeb_jdbc", "root", "123456");
            String sql="insert into account values(null,'王五',3000)";
            statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count>0){
                System.out.println("添加成功！");
            }else {
                System.out.println("添加失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
