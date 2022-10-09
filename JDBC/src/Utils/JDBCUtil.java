package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 静态代码块
     * 读取配置文件，连接数据库
     */
    static{
        try {
            Properties pro=new Properties();

            //动态获取src目录下的文件----ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL res=classLoader.getResource("jdbc.properties");
            String path= res.getPath();

            pro.load(new FileReader(path));

            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
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

    public static void close(ResultSet rs,Statement stmt,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
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
    public static void close(ResultSet rs,PreparedStatement stmt,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
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
