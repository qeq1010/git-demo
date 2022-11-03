package com.houtai.service;

import com.houtai.pojo.*;

import java.util.List;

public interface OrderCatService {

    /**
     * 查询所有
     *
     * @return
     */

    List<OrderCat> selectOrderCat(OrderCat orderCat);



    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    void deleteOrderCatById(int id);



    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);


    /**
     * 订单详情表添加数据
     */
    void addOrderInfo(List<OrderInfo> orderInfos);

    /**
     * 订单表添加数据
     * @param order
     */
    void addOrder(Order order);


//    Order selectOrder(Order order);




}
