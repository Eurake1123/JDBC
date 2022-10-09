import Utils.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) {
        String user=null;
        String password=null;
        Scanner in=new Scanner(System.in);
        user= in.nextLine();
        password=in.nextLine();
        if(login(user,password)){
            System.out.println("登陆成功！");
        }else{
            System.out.println("登陆失败，请检查用户名或密码！");
        }
    }

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */
    public static boolean login(String user, String password){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        if(user==null&&password==null){
            return false;
        }
        try {
            connection = JDBCUtil.getConnection();
            statement=connection.createStatement();
            String sql="select * from user where username='"+user+"' and password='"+password+"'";
            resultSet=statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
    }

    /**
     * 登录（防止SQL注入）
     * @param user
     * @param password
     * @return
     */
    public static boolean login2(String user, String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        if(user==null&&password==null){
            return false;
        }
        try {
            String sql="select * from user where username=? and password=?";
            connection = JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
    }
}
