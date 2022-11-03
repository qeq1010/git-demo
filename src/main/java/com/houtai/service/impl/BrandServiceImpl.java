/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.BrandMapper;
import com.houtai.pojo.Brand;
import com.houtai.pojo.PageBean;
import com.houtai.service.BrandService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

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
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.计算开始索引
         int begin=(currentPage-1)*pageSize;

         //5.计算查询条目数
        int size=pageSize;

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
          List<Brand> rows = mapper.selectByPage(begin, size);

        //7.查询总记录数
           int totalCount=mapper.selectTotalCount();

        //8.封装PageBean对象
           PageBean<Brand> pageBean = new PageBean<>();
           pageBean.setRows(rows);
           pageBean.setTotalCount(totalCount);



        //9. 释放资源
        sqlSession.close();



           return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCoundition(int currentPage, int pageSize, Brand brand) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;

        //5.计算查询条目数
        int size=pageSize;

        //处理brand条件,模糊表达式
        String userName = brand.getUserName();
        if(userName!=null&&userName.length()>0){
            brand.setUserName("%"+userName+"%");
        }

        String fname = brand.getFname();
        if(fname!=null&&fname.length()>0){
            brand.setFname("%"+fname+"%");
        }

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin,size,brand);

        //7.查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //8.封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //9. 释放资源
        sqlSession.close();

        return pageBean;
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
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

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
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        mapper.deleteBrandById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

}
