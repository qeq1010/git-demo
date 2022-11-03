package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;
import com.houtai.pojo.Brand;
import com.houtai.pojo.User;
import com.houtai.service.UserOrderService;
import com.houtai.service.impl.UserOrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet("/userOrder/*")
public class UserOrderServlet extends BaseServlet {

    private UserOrderService userOrderService = new UserOrderServiceImpl();

    /**
     * 查询全部数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user2=(User)request.getSession().getAttribute("user");

        //拿到session中的用户id
        Brand brand = new Brand();
        brand.setId(user2.getId());

        //1. 调用service查询
        List<Brand> brands = userOrderService.selectAll(brand);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(brands);

        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UtF-8");
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为Brand对象
        Brand brand1 = JSON.parseObject(params, Brand.class);

        //获取session中的键值对
        User user=(User)request.getSession().getAttribute("user");

        //封装对象
        Brand brand3 = new Brand();
        brand3.setUserName(brand1.getUserName());
        brand3.setFname(brand1.getFname());
        brand3.setPrice(brand1.getPrice());
        brand3.setId(user.getId());

        System.out.println(brand3);

        //2. 调用service添加
        userOrderService.add(brand3);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为int[]对象
        int[] ids = JSON.parseObject(params, int[].class);

        //2. 调用service删除
        userOrderService.deleteByIds(ids);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }



    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UtF-8");
        //1.接收修改后的品牌数据
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //将接收过来的id转为int型
        //String _id=request.getParameter("id");
        //int id=Integer.parseInt(_id);

        //将接收过来的JSON数据e对象,转为Brand对象
        Brand _brand = JSON.parseObject(params, Brand.class);

        //将需要修改的内容封装为一个brand对象
        Brand brand=new Brand();
        //brand.setId(id);
        brand.setId(_brand.getId());
        brand.setUserName(_brand.getUserName());
        brand.setFname(_brand.getFname());
        brand.setPrice(_brand.getPrice());

        //2.调用service方法进行修改
        userOrderService.update(brand);

        //3.响应修改成功的标识
        response.getWriter().write("updateSuccess");

    }

    /**
     * 根据id删除对象
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteBrandById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //将接收过来的id转为int型
        String _id=request.getParameter("id");
        int id=Integer.parseInt(_id);


        //2.调用service方法添加
        userOrderService.deleteBrandById(id);

        //3.响应添加成功的标识
        response.getWriter().write("deleteSuccess");

    }

}
