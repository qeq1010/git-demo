package com.houtai.service;

import com.houtai.pojo.Order;
import com.houtai.pojo.OrderInfo;
import com.houtai.pojo.OrderShop;

import java.util.List;

public interface OrderListService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Order> selectAll(Order order);


    //订单查详情
    List<OrderInfo> selectOrderInfo(Order order);



}
