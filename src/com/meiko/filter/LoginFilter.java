package com.meiko.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Meiko
 * @date 2019/5/6
 */
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0. 转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //1. 获取请求资源，截取
        String uri = request.getRequestURI();
        // 截取 【login.jsp或login】
        String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());

        //2. 判断： 先放行一些资源：/login.jsp、/login
        if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
            // 放行
            chain.doFilter(request, response);
        }
        else {
            //3. 对其他资源进行拦截
            //3.1 先获取Session、获取session中的登陆用户(loginInfo)
            HttpSession session = request.getSession(false);
            // 判断
            if (session != null) {

                Object obj = session.getAttribute("loginInfo");

                //3.2如果获取的内容不为空，说明已经登陆，放行
                if (obj != null) {
                    // 放行
                    chain.doFilter(request, response);
                } else {
                    //3.3如果获取的内容为空，说明没有登陆； 跳转到登陆
                    uri = "/login.jsp";
                }

            } else {
                // 肯定没有登陆
                uri = "/login.jsp";
            }
            request.getRequestDispatcher(uri).forward(request, response);
        }
    }


    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
