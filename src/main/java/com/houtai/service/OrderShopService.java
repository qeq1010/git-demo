package com.houtai.service;

import com.houtai.pojo.Brand;
import com.houtai.pojo.OrderShop;
import com.houtai.pojo.PageBean;

import java.util.List;

public interface OrderShopService {

    /**
     * 查询所有
     *
     * @return
     */
    List<OrderShop> selectAllOrder();


    boolean registerShop(OrderShop orderShop);


}
