package JdbcTemplate;

import Domain.Emp;
import Utils.DruitdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TemplateTest {
    private  static JdbcTemplate jdbcTemplate = new JdbcTemplate(DruitdUtils.getDataSource());

    @Test
    public void test01(){
        String sql = "update emp set salary =25000 where id = ?";
        int count = jdbcTemplate.update(sql, 100);
        System.out.println(count);
    }

    @Test
    public void test02(){
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = jdbcTemplate.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    @Test
    public void test03(){
        String sql = "delete from emp where id = ?";
        int count = jdbcTemplate.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 将查询结果封装为Map
     */
    @Test
    public void test04(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 100);
        //只能返回一条记录
        System.out.println(stringObjectMap);
    }

    /**
     * 将查询结果集封装为list
     * 每条记录封装为map
     * 然后将map封装为list
     */
    @Test
    public void test05(){
        String sql = "select * from emp";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 将查询结果集封装为list
     * 每条记录封装为Emp对象
     */
    @Test
    public void test06(){
        String sql = "select * from emp";
        /*List<Emp> list = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ename");
                int jobId = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joinDate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int deptId = resultSet.getInt("dept_id");
                Emp emp = new Emp(id, name, jobId, mgr, joinDate, salary, bonus, deptId);
                return emp;
            }
        });*/
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test07(){
        String sql = "select count(id) from emp";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
