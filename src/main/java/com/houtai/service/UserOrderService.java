package com.houtai.service;

import com.houtai.pojo.Brand;
import com.houtai.pojo.OrderShop;
import com.houtai.pojo.PageBean;
import com.houtai.pojo.User;

import java.util.List;

public interface UserOrderService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll(Brand brand);

    /**
     * 添加数据
     *
     * @param brand
     */
    void add(Brand brand);


    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);




    /**
     * 修改数据
     * @param brand 品牌
     */
    void update(Brand brand);

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    void deleteBrandById(int id);

    /**
     * 查询所有
     *
     * @return
     */
}
