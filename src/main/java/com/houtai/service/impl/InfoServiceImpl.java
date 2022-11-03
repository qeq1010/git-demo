/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.InfoMapper;
import com.houtai.pojo.Info;
import com.houtai.pojo.PageBean;
import com.houtai.service.InfoService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class InfoServiceImpl implements InfoService {

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Info> selectAll() {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        //4. 调用方法
        List<Info> infos = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return infos;
    }

    @Override
    public void add(Info info) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        mapper.add(info);

        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Info> selectByPage(int currentPage, int pageSize) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        //4.计算开始索引
         int begin=(currentPage-1)*pageSize;

         //5.计算查询条目数
        int size=pageSize;

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
          List<Info> rows = mapper.selectByPage(begin, size);

        //7.查询总记录数
           int totalCount=mapper.selectTotalCount();

        //8.封装PageBean对象
           PageBean<Info> pageBean = new PageBean<>();
           pageBean.setRows(rows);
           pageBean.setTotalCount(totalCount);



        //9. 释放资源
        sqlSession.close();



           return pageBean;
    }

    @Override
    public PageBean<Info> selectByPageAndCoundition(int currentPage, int pageSize, Info info) {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;

        //5.计算查询条目数
        int size=pageSize;

        //处理brand条件,模糊表达式
        String uname = info.getUname();
        if(uname!=null&&uname.length()>0){
            info.setUname("%"+uname+"%");
        }


        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Info> rows = mapper.selectByPageAndCondition(begin,size,info);

        //7.查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(info);

        //8.封装PageBean对象
        PageBean<Info> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //9. 释放资源
        sqlSession.close();

        return pageBean;
    }

    /**
     * 修改数据
     * @param info 品牌
     */
    @Override
    public void update(Info info) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        //4.调用方法
        mapper.update(info);
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
    public void deleteInfoById(int id) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);

        //4.调用方法
        mapper.deleteInfoById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

}
