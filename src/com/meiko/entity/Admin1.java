package com.meiko.entity;

/**
 * 管理员账号
 * @author Meiko
 * @date 2019/5/6
 */
public class Admin1 {
    private int id;
    private String userName;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
