/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.BrandMapper;
import com.houtai.mapper.OrderListMapper;
import com.houtai.mapper.OrderShopMapper;
import com.houtai.pojo.Order;
import com.houtai.pojo.OrderInfo;
import com.houtai.pojo.OrderShop;
import com.houtai.service.OrderListService;
import com.houtai.service.OrderShopService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderListServiceImpl implements OrderListService{

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Order> selectAll(Order order) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        OrderListMapper mapper = sqlSession.getMapper(OrderListMapper.class);

        //4. 调用方法
        List<Order> orders = mapper.selectAll(order);

        //5. 释放资源
        sqlSession.close();

        return orders;
    }

    /**
     * 根据id查询对象
     * @param order 要删除对象的id
     */
    @Override
    public List<OrderInfo> selectOrderInfo(Order order) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        OrderListMapper mapper = sqlSession.getMapper(OrderListMapper.class);

        //4.调用方法
        List<OrderInfo> orderInfos = mapper.selectOrderInfo(order);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        return orderInfos;
    }

    }

