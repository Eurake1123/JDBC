package JDBC;

import Domain.Emp;
import Utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo3 {
    public static void main(String[] args) {
        List<Emp> list=findAll();
        //System.out.println(list);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    /**
     * 查询所有emp对象
     * @return
     */
    public static List<Emp> findAll(){
        Connection conn=null;
        Statement state=null;
        ResultSet rs=null;
        List<Emp> list=null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaWeb_jdbc", "root", "123456");
//            state = conn.createStatement();
            conn = JDBCUtil.getConnection();
            state=conn.createStatement();
            String sql="select * from emp";
            rs= state.executeQuery(sql);
            Emp emp=null;
            list=new ArrayList<>();
            while (rs.next()){
                int id=rs.getInt("id");
                String eName=rs.getString("ename");
                int jobId=rs.getInt("job_id");
                int mgr=rs.getInt("mgr");
                Date joinDate=rs.getDate("joindate");
                double salary=rs.getDouble("salary");
                double bonus=rs.getDouble("bonus");
                int deptId=rs.getInt("dept_id");
                emp=new Emp(id,eName,jobId,mgr,joinDate,salary,bonus,deptId);
                list.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(rs,state,conn);
//            if(rs!=null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(state!=null){
//                try {
//                    state.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
        return list;
    }
}
