package com.meiko.dao.impl;

import com.meiko.dao.IEmployeeDao;
import com.meiko.entity.Employee;
import com.meiko.utils.JdbcUtil;
import com.meiko.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据访问层实现
 *
 * @author Meiko
 * @date 2019/5/5
 */
public class EmployeeDao implements IEmployeeDao {

    @Override
    public void getAll(PageBean<Employee> pb) {

        //1. 查询总共有多少条记录，并设置到pd对象中
        int totalCount = this.getTotalCount();
        pb.setTotalCount(totalCount);

        //2.判断当前页码是否合法，并设置它
       if (pb.getCurrentPage() <=0) {
            pb.setCurrentPage(1);
       } else if (pb.getCurrentPage() > pb.getTotalPage()){
           pb.setCurrentPage(pb.getTotalPage());
       }

        //3.获取当前页： 计算查询的起始行、返回的行数
        int currentPage = pb.getCurrentPage();
        int index = (currentPage -1 ) * pb.getPageCount();
        int count = pb.getPageCount();

        try {
            //4. 分页查询数据;  把查询到的数据设置到pb对象中
            String sql = "select * from employee limit ?,?";
            // 得到Queryrunner对象
            QueryRunner qr = JdbcUtil.getQueryRunner();
            // 根据当前页，查询当前页数据(一页数据)
            List<Employee> list = qr.query(sql, new BeanListHandler<>(Employee.class), index, count);
            // 设置到pb对象中
            pb.setPageData(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getTotalCount() {
        String sql = "select count(*) from employee";
        try {
            // 创建QueryRunner对象
            QueryRunner qr = JdbcUtil.getQueryRunner();
            // 执行查询， 返回结果的第一行的第一列
            Long count = qr.query(sql, new ScalarHandler<Long>());
            return count.intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
