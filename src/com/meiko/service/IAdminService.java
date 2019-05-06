package com.meiko.service;

import com.meiko.entity.Admin1;

/**
 * @author Meiko
 * @date 2019/5/6
 */
public interface IAdminService {
    /**
     * 根据用户名密码查询
     * @param admin
     * @return
     */
    Admin1 findByNameAndPwd(Admin1 admin);
}
