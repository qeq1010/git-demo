/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;


import com.houtai.mapper.SalaryMapper;
import com.houtai.pojo.PageBean;
import com.houtai.pojo.Salary;
import com.houtai.service.SalaryService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SalaryServiceImpl implements SalaryService {

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Salary> selectAll() {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        //4. 调用方法
        List<Salary> salaries = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return salaries;
    }

    @Override
    public void add(Salary salary) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        mapper.add(salary);

        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Salary> selectByPage(int currentPage, int pageSize) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        //4.计算开始索引
         int begin=(currentPage-1)*pageSize;

         //5.计算查询条目数
        int size=pageSize;

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
          List<Salary> rows = mapper.selectByPage(begin, size);

        //7.查询总记录数
           int totalCount=mapper.selectTotalCount();

        //8.封装PageBean对象
           PageBean<Salary> pageBean = new PageBean<>();
           pageBean.setRows(rows);
           pageBean.setTotalCount(totalCount);



        //9. 释放资源
        sqlSession.close();



           return pageBean;
    }

    @Override
    public PageBean<Salary> selectByPageAndCoundition(int currentPage, int pageSize, Salary salary) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;

        //5.计算查询条目数
        int size=pageSize;

        //处理brand条件,模糊表达式
        String name = salary.getName();
        if(name!=null&&name.length()>0){
            salary.setName("%"+name+"%");
        }


        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Salary> rows = mapper.selectByPageAndCondition(begin,size,salary);

        //7.查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(salary);

        //8.封装PageBean对象
        PageBean<Salary> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //9. 释放资源
        sqlSession.close();

        return pageBean;
    }

    /**
     * 修改数据
     * @param salary 品牌
     */
    @Override
    public void update(Salary salary) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        //4.调用方法
        mapper.update(salary);
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
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);

        //4.调用方法
        mapper.deleteBrandById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

}
