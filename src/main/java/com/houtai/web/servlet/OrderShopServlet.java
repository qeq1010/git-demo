package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;
import com.houtai.pojo.OrderShop;
import com.houtai.pojo.User;
import com.houtai.service.OrderShopService;
import com.houtai.service.impl.OrderShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;


@WebServlet("/orderShop/*")
public class OrderShopServlet extends BaseServlet {

    private OrderShopService OrderShopService = new OrderShopServiceImpl();

    /**
     * 查询全部数据在售商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void selectAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用service查询
        List<OrderShop> orderShops = OrderShopService.selectAllOrder();

        //2. 转为JSON
        String jsonString = JSON.toJSONString(orderShops);

        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


//获取用户购物车信息，商品存在数量加一
    public void registerShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UtF-8");
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        OrderShop orderShop = JSON.parseObject(params, OrderShop.class);

//        System.out.println(orderShop);

        //获取session中的键值对，转成对象？
        User user = (User) request.getSession().getAttribute("user");

        /*System.out.println(user2);*/

        //封装对象
        OrderShop orderShop2 = new OrderShop();
        orderShop2.setId(user.getId());
        orderShop2.setFname(orderShop.getFname());
        orderShop2.setPrice(orderShop.getPrice());

//        System.out.println(orderShop2);



        boolean b = OrderShopService.registerShop(orderShop2);

        //3.
        if (b) {
            //返回成功信息
            response.getWriter().write("success");

        } else {
            //返回失败信息
            response.getWriter().write("success");
        }
    }
}
