package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;
import com.houtai.pojo.*;
import com.houtai.service.OrderCatService;
import com.houtai.service.OrderShopService;
import com.houtai.service.impl.OrderCatServiceImpl;
import org.apache.ibatis.javassist.expr.NewArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/orderCat/*")
public class OrderCatServlet extends BaseServlet {

    private OrderCatService OrderCatService = new OrderCatServiceImpl();

    /**
     * 查询全部数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    //获取用户购物车信息
    public void selectOrderCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取session中的键值对，转成对象
        User user = (User) request.getSession().getAttribute("user");

        /*System.out.println(user2);*/

        //封装对象
        OrderCat orderCat = new OrderCat();
        orderCat.setId(user.getId());

        //1. 调用service查询
        List<OrderCat> orderCat1 = OrderCatService.selectOrderCat(orderCat);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(orderCat1);

        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 根据id删除对象
     */
    public void deleteOrderCatById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //将接收过来的id转为int型
        String _id=request.getParameter("id");
        int id=Integer.parseInt(_id);

        //2.调用service方法添加
        OrderCatService.deleteOrderCatById(id);

        //3.响应添加成功的标识
        response.getWriter().write("deleteSuccess");

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
        OrderCatService.deleteByIds(ids);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }


    //用户下单，订单详情表添加数据
    public void addOrderInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UtF-8");

        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串


        //转为list
        List<OrderInfo> orderInfos = JSON.parseArray(params, OrderInfo.class);


        /*//获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        String tim = df.format(new Date());*/


        //获取session对象
        User user = (User) request.getSession().getAttribute("user");


        System.out.println(orderInfos);


        OrderCatService.addOrderInfo(orderInfos);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }



    //订单表添加数据
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取总金额和
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //将接收过来的JSON数据e对象,转为Brand对象
        Order order = JSON.parseObject(params, Order.class);

        //获取session对象
        User user = (User) request.getSession().getAttribute("user");

        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        String tim = df.format(new Date());

        Order order1 = new Order();
        order1.setCartTotalPrice(order.getCartTotalPrice());
        order1.setCartTotalCount(order.getCartTotalCount());
        order1.setIds(user.getId());
        order1.setOrderId(tim);

        System.out.println(order1);


        OrderCatService.addOrder(order1);

//        System.out.println(order1);
        //3. 响应成功的标识
        response.getWriter().write("success");
    }






/*    public void registerShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UtF-8");
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        OrderShop orderShop = JSON.parseObject(params, OrderShop.class);

//        System.out.println(orderShop);

        //获取session中的键值对，转成对象？
        User user = (User) request.getSession().getAttribute("user");

        *//*System.out.println(user2);*//*

        //封装对象
        OrderShop orderShop2 = new OrderShop();
        orderShop2.setId(user.getId());
        orderShop2.setFname(orderShop.getFname());
        orderShop2.setPrice(orderShop.getPrice());

//        System.out.println(orderShop2);



        boolean b = OrderShopService.registerShop(orderShop2);

        //3. 判断注册成功与否
        if (b) {
            //返回成功信息
            response.getWriter().write("success");

        } else {
            //返回失败信息
            response.getWriter().write("error");

        }
    }*/
}
