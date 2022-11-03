package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;
import com.houtai.pojo.Admin;
import com.houtai.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminService();


    /*管理员登录*/
    public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UtF-8");
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //json转为admin对象
        Admin admin = JSON.parseObject(params, Admin.class);


        Admin admin1 = adminService.adminLogin(admin);

        //3. 判断
        if (admin1 != null) {

            //将登陆成功后的admin对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin1);


            response.getWriter().write("success");
        } else {
            response.getWriter().write("error");
        }
    }
/*管理员修改密码*/
    public void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UtF-8");
        //接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //json转为user对象
        Admin admin = JSON.parseObject(params, Admin.class);


        /*HttpSession session = request.getSession();
        Object admin1 = session.getAttribute("admin");*/

        //获取session中的键值对
        Admin admin2=(Admin)request.getSession().getAttribute("admin");

        /*System.out.println(admin2);*/

        //封装对象
        Admin admin3 = new Admin();
        admin3.setId(admin2.getId());
        admin3.setPass(admin.getPass());
        admin3.setPassword(admin.getPassword());

        /*System.out.println(admin3);*/


        int i = adminService.updateAdmin(admin3);

        //3. 判断注册成功与否
        if (i>0) {

            //返回成功信息
            response.getWriter().write("success");
        } else {

            //返回失败信息
            response.getWriter().write("error");

        }
    }
}

