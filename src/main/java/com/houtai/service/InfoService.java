package com.houtai.service;

import com.houtai.pojo.Info;
import com.houtai.pojo.PageBean;

import java.util.List;

public interface InfoService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Info> selectAll();

    /**
     * 添加数据
     *
     * @param info
     */
    void add(Info info);


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
    PageBean<Info> selectByPage(int currentPage,int pageSize);


    /**
     * 分页条件查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Info> selectByPageAndCoundition(int currentPage,int pageSize,Info info);


    /**
     * 修改数据
     * @param info 品牌
     */
    void update(Info info);

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    void deleteInfoById(int id);

}
