package com.meiko.entity;

/**
 * 实体类设计 (因为用了DbUtils组件，属性要与数据库中字段一致)
 *
 * @author Meiko
 * @date 2019/5/5
 */
public class Employee {
    private int empId;
    private String empName;
    private int dept_id;

    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public int getDept_id() {
        return dept_id;
    }
    public void setDept_id(int deptId) {
        dept_id = deptId;
    }
}
