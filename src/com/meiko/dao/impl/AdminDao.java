package com.meiko.dao.impl;

import com.meiko.dao.IAdminDao;
import com.meiko.entity.Admin1;
import com.meiko.utils.JdbcUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author Meiko
 * @date 2019/5/6
 */

public class AdminDao implements IAdminDao {

    @Override
    public Admin1 findByNameAndPwd(Admin1 admin) {
        try {
            String sql = "select * from admin1 where userName=? and pwd=?";
            return JdbcUtil.getQueryRunner()
                    .query(sql,
                            new BeanHandler<>(Admin1.class),
                            admin.getUserName(),
                            admin.getPwd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
