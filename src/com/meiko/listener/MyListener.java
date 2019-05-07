package com.meiko.listener;

/**
 * @author Meiko
 * @date 2019/5/7
 */

import com.meiko.entity.Admin1;
import com.meiko.utils.DateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public MyListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
         初始化servlet上下文时（部署Web应用程序时）将调用此方法。您可以在此处初始化与servlet上下文相关的数据。
      */
        System.out.println("服务器已启动！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
         取消部署Servlet上下文（Web应用程序）或关闭Application Server时，将调用此方法。
      */
        System.out.println("服务器已销毁！");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {

        HttpSession session = sbe.getSession();

        Admin1 admin = (Admin1)session.getAttribute("loginInfo");

        System.out.println(DateUtil.getCurrentTime() +",管理员"+admin.getUserName()+"登陆了系统！");

      /* This method is called when an attribute 
         is added to a session.
      */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        // 获取sesison对象
        HttpSession session = sbe.getSession();

        // 获取替换前的值
        Object old = sbe.getValue();
        System.out.println("老用户退出：" + old);

        // 获取新值
        Object obj_new = session.getAttribute("userName");
        System.out.println("新用户登陆：" + obj_new);
    }
}
