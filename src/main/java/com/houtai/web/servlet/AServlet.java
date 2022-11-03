package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;

import com.houtai.pojo.User;
import com.houtai.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet("/a/*")
public class AServlet extends BaseServlet {

    private UserService userService = new UserService();


/*用户登录*/
    public void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UtF-8");
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        User user = JSON.parseObject(params, User.class);

        User user1 = userService.selectA(user);

        //3. 判断
        if (user1 != null) {

            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user", user1);

            response.getWriter().write("success");
        } else {
            response.getWriter().write("error");
        }
}

/*用户注册*/
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        User user = JSON.parseObject(params, User.class);

        //获取程序生成的验证码，从session中获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //验证码只能用一次
        session.removeAttribute("checkCodeGen");

        //比对
        if(checkCodeGen==null || !checkCodeGen.equalsIgnoreCase(user.vercode)){
            //不允许注册

            //注册失败
            response.getWriter().write("errors");

            return;
        }

        String s = new String(user.username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);


        //2. 调用service 注册
        boolean flag = userService.register(user);
        //3. 判断注册成功与否
        if (flag) {
            //返回信息

            response.getWriter().write("success");
        } else {
            //返回信息
            response.getWriter().write("error");
        }
    }


/*用户修改密码*/

public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UtF-8");
    //接收数据
    BufferedReader br = request.getReader();
    String params = br.readLine();//json字符串

    //json转为user对象
    User user = JSON.parseObject(params, User.class);


        /*HttpSession session = request.getSession();
        Object admin1 = session.getAttribute("admin");*/

    //获取session中的键值对，转成对象？
    User user2=(User)request.getSession().getAttribute("user");

    /*System.out.println(user2);*/

    //封装对象
    User user3 = new User();
    user3.setId(user2.getId());
    user3.setPass(user.getPass());
    user3.setPassword(user.getPassword());

    /*System.out.println(user3);*/


    int i = userService.updateUser(user3);

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
