package com.houtai.service;

import com.houtai.pojo.Inventory;
import com.houtai.pojo.PageBean;

import java.util.List;

public interface InventoryService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Inventory> selectAll();

    /**
     * 添加数据
     *
     * @param inventory
     */
    void add(Inventory inventory);


    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);


    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Inventory> selectByPage(int currentPage,int pageSize);


    /**
     * 分页条件查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Inventory> selectByPageAndCoundition(int currentPage,int pageSize,Inventory inventory);


    /**
     * 修改数据
     * @param inventory 品牌
     */
    void update(Inventory inventory);

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    void deleteInventoryById(int id);

}
