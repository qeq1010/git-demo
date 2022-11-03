package com.houtai.service;

import com.houtai.pojo.PageBean;
import com.houtai.pojo.Salary;
import java.util.List;

public interface SalaryService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Salary> selectAll();

    /**
     * 添加数据
     *
     * @param salary
     */
    void add(Salary salary);


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
    PageBean<Salary> selectByPage(int currentPage,int pageSize);


    /**
     * 分页条件查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Salary> selectByPageAndCoundition(int currentPage,int pageSize,Salary salary);


    /**
     * 修改数据
     * @param salary 品牌
     */
    void update(Salary salary);

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    void deleteBrandById(int id);

}
