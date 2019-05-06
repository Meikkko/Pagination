package com.meiko.dao;

import com.meiko.entity.Admin1;

/**
 * @author Meiko
 * @date 2019/5/6
 */
public interface IAdminDao {
    /**
     * 根据用户名密码查询
     * @param admin
     * @return
     */
    Admin1 findByNameAndPwd(Admin1 admin);
}
