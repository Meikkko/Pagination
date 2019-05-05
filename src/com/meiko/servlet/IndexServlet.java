package com.meiko.servlet;

import com.meiko.entity.Employee;
import com.meiko.service.IEmployeeService;
import com.meiko.service.impl.EmployeeService;
import com.meiko.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Meiko
 * @date 2019/5/5
 */
public class IndexServlet extends HttpServlet {

    private IEmployeeService employeeService = new EmployeeService();

    private String uri;

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1. 获取“当前页”参数；  (第一次访问当前页为null)
            String currPage = request.getParameter("currentPage");
            // 判断
            if (currPage == null || "".equals(currPage.trim())){
                currPage = "1";
            }
            // 转换
            int currentPage = Integer.parseInt(currPage);

            //2. 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<Employee> pageBean = new PageBean<Employee>();
            pageBean.setCurrentPage(currentPage);

            //3. 调用service
            employeeService.getAll(pageBean);

            //4. 保存pageBean对象，到request域中
            request.setAttribute("pageBean", pageBean);

            //5. 跳转
            uri = "/WEB-INF/list.jsp";
        } catch (Exception e) {
            e.printStackTrace();  // 测试使用
            // 出现错误，跳转到错误页面；给用户友好提示
          uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
