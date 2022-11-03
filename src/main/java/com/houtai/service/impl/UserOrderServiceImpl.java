/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.UserOrderMapper;
import com.houtai.pojo.Brand;
import com.houtai.service.UserOrderService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserOrderServiceImpl implements UserOrderService {

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll(Brand brand) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll(brand);

        //5. 释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);

        mapper.add(brand);

        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }


    /**
     * 修改数据
     * @param brand 品牌
     */
    @Override
    public void update(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);

        //4.调用方法
        mapper.update(brand);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    @Override
    public void deleteBrandById(int id) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);

        //4.调用方法
        mapper.deleteBrandById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

}
