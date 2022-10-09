package DataSource.Druid;

import Utils.DruitdUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo1 {
    public static void main(String[] args) {
        try {
            Connection connection= DruitdUtils.getConnection();
            String sql="insert into account values(null,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"黑狗");
            preparedStatement.setString(2,"111111");
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
            DruitdUtils.close(null,preparedStatement,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
