/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.service.impl;

import com.houtai.mapper.InventoryMapper;
import com.houtai.pojo.Inventory;
import com.houtai.pojo.PageBean;
import com.houtai.service.InventoryService;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class InventoryServiceImpl implements InventoryService{

    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Inventory> selectAll() {

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        //4. 调用方法
        List<Inventory> inventories = mapper.sellAll();

        //5. 释放资源
        sqlSession.close();

        return inventories;
    }

    @Override
    public void add(Inventory inventory) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        mapper.add(inventory);

        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Inventory> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;

        //5.计算查询条目数
        int size=pageSize;

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Inventory> rows = mapper.selectByPage(begin, size);

        //7.查询总记录数
        int totalCount=mapper.selectTotalCount();

        //8.封装PageBean对象
        PageBean<Inventory> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);



        //9. 释放资源
        sqlSession.close();



        return pageBean;
    }

    @Override
    public PageBean<Inventory> selectByPageAndCoundition(int currentPage, int pageSize, Inventory inventory) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;

        //5.计算查询条目数
        int size=pageSize;

        //处理brand条件,模糊表达式
        String fname = inventory.getFname();
        if(fname!=null&&fname.length()>0){
            inventory.setFname("%"+fname+"%");
        }

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Inventory> rows = mapper.selectByPageAndCondition(begin,size,inventory);

        //7.查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(inventory);

        //8.封装PageBean对象
        PageBean<Inventory> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //9. 释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public void update(Inventory inventory) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        //4.调用方法
        mapper.update(inventory);
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
    public void deleteInventoryById(int id) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);

        //4.调用方法
        mapper.deleteInventoryById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

}
