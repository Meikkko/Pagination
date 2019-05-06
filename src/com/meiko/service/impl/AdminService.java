package com.meiko.service.impl;

import com.meiko.dao.IAdminDao;
import com.meiko.dao.impl.AdminDao;
import com.meiko.entity.Admin1;
import com.meiko.service.IAdminService;

/**
 * @author Meiko
 * @date 2019/5/6
 */
public class AdminService implements IAdminService {
    private IAdminDao adminDao = new AdminDao();
    @Override
    public Admin1 findByNameAndPwd(Admin1 admin) {
        try {
            return adminDao.findByNameAndPwd(admin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
