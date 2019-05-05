package com.meiko.service.impl;

import com.meiko.dao.IEmployeeDao;
import com.meiko.dao.impl.EmployeeDao;
import com.meiko.entity.Employee;
import com.meiko.service.IEmployeeService;
import com.meiko.utils.PageBean;

/**
 * @author Meiko
 * @date 2019/5/5
 */
public class EmployeeService implements IEmployeeService {

    private IEmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void getAll(PageBean<Employee> pb) {
        employeeDao.getAll(pb);
    }
}
