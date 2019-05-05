package com.meiko.dao;

import com.meiko.entity.Employee;
import com.meiko.utils.PageBean;

/**
 * 数据访问层接口设计
 * @author Meiko
 * @date 2019/5/5
 */
public interface IEmployeeDao {
    /**
     * 分页查询设计
     */
    public void getAll(PageBean<Employee> pb);

    /**
     * 查询总记录数
     */
    public int getTotalCount();
}
