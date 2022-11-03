package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;
import com.houtai.pojo.*;
import com.houtai.service.OrderListService;
import com.houtai.service.OrderShopService;
import com.houtai.service.impl.OrderListServiceImpl;
import com.houtai.service.impl.OrderShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet("/orderList/*")
public class OrderListServlet extends BaseServlet {

    private OrderListService OrderListService = new OrderListServiceImpl();

    /**
     * 查询全部数据，用户订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

//获取用户订单信息
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("user");


        Order order = new Order();
        order.setIds(user.getId());

        //1. 调用service查询
        List<Order> orders = OrderListService.selectAll(order);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(orders);

        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    //获取订单详情
    public void selectOrderInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String _id=request.getParameter("id");
        int id=Integer.parseInt(_id);



        User user = (User) request.getSession().getAttribute("user");

        Order order1 = new Order();
        order1.setIds(user.getId());
        order1.setId(id);

        //1. 调用service查询
        List<OrderInfo> orderInfos = OrderListService.selectOrderInfo(order1);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(orderInfos);


//        request.getRequestDispatcher("/dingdanxiangqing.html").forward(request,response);

        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }


}
