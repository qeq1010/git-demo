/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.BrandMapper;
import com.houtai.mapper.OrderShopMapper;
import com.houtai.mapper.UserMapper;
import com.houtai.mapper.UserOrderMapper;
import com.houtai.pojo.Brand;
import com.houtai.pojo.OrderShop;
import com.houtai.pojo.PageBean;
import com.houtai.pojo.User;
import com.houtai.service.BrandService;
import com.houtai.service.OrderShopService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderShopServiceImpl implements OrderShopService{

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<OrderShop> selectAllOrder() {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        OrderShopMapper mapper = sqlSession.getMapper(OrderShopMapper.class);

        //4. 调用方法
        List<OrderShop> orderShops= mapper.selectAllOrder();

        //5. 释放资源
        sqlSession.close();

        return orderShops;
    }

    @Override
    public boolean registerShop(OrderShop orderShop) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        OrderShopMapper mapper = sqlSession.getMapper(OrderShopMapper.class);

        //4. 判断是否存在
        OrderShop u = mapper.selectByShop(orderShop);

        if (u == null) {
            // 不存在，添加
            mapper.addShop(orderShop);
            sqlSession.commit();
        }else {
            mapper.updateShop(orderShop);
            sqlSession.commit();
        }
        sqlSession.close();
        //u==null 返回true  u!=null 返回false
        return u == null;
    }
    }

