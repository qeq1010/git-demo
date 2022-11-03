/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.BrandMapper;
import com.houtai.mapper.OrderCatMapper;
import com.houtai.mapper.UserMapper;
import com.houtai.pojo.*;
import com.houtai.service.OrderCatService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderCatServiceImpl implements OrderCatService{

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<OrderCat> selectOrderCat(OrderCat orderCat) {

            //2. 获取SqlSession对象
            SqlSession sqlSession = factory.openSession();
            //3. 获取BrandMapper
            OrderCatMapper mapper = sqlSession.getMapper(OrderCatMapper.class);

            //4. 调用方法
            List<OrderCat> orderCat1 = mapper.selectOrderCat(orderCat);

        //5. 释放资源
            sqlSession.close();

            return orderCat1;
        }

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    @Override
    public void deleteOrderCatById(int id) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        OrderCatMapper mapper = sqlSession.getMapper(OrderCatMapper.class);

        //4.调用方法
        mapper.deleteOrderCatById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /*批量删除*/
    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        OrderCatMapper mapper = sqlSession.getMapper(OrderCatMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    /*订单详情表添加数据*/
    @Override
    public void addOrderInfo(List<OrderInfo> orderInfos) {

        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        OrderCatMapper mapper = sqlSession.getMapper(OrderCatMapper.class);

        mapper.addOrderInfo(orderInfos);

        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }
/*订单表添加数据*/
    @Override
    public void addOrder(Order order) {

        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        OrderCatMapper mapper = sqlSession.getMapper(OrderCatMapper.class);

        mapper.addOrder(order);

        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }






}

