package com.meiko.service;

import com.meiko.entity.Employee;
import com.meiko.utils.PageBean;

/**
 * @author Meiko
 * @date 2019/5/5
 */
public interface IEmployeeService {
    /**
     * 分页查询数据
     */
    public void getAll(PageBean<Employee> pb);
}
