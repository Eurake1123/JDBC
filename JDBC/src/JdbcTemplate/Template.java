package JdbcTemplate;

import Utils.DruitdUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Template {
    public static void main(String[] args) {
        JdbcTemplate template=new JdbcTemplate(DruitdUtils.getDataSource());

        String sql="update account set balance =10000 where id=?";
        int count = template.update(sql, 2);//自动释放资源
        System.out.println(count);
    }
}
