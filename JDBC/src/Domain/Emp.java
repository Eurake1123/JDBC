package Domain;

import java.util.Date;

public class Emp {
    private Integer id;
    private String eName;
    private Integer jobId;
    private Integer mgr;
    private Date joinDate;
    private Double salary;
    private Double bonus;
    private Integer deptId;

    public Emp(){}

    public Emp(int id, String eName, int jobId, int mgr, Date joinDate, double salary, double bonus, int deptId) {
        this.id = id;
        this.eName = eName;
        this.jobId = jobId;
        this.mgr = mgr;
        this.joinDate = joinDate;
        this.salary = salary;
        this.bonus = bonus;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", eName='" + eName + '\'' +
                ", jobId=" + jobId +
                ", mgr=" + mgr +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", deptId=" + deptId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
