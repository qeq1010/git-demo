/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.mapper;

import com.houtai.pojo.Inventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InventoryMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from o_repertory")
    List<Inventory> sellAll();


    /**
     * 添加数据
     *
     * @param inventory
     */
    @Insert("insert into o_repertory values(null,#{fname},#{inventory})")
    void add(Inventory inventory);


    /**
     * 批量删除
     *
     * @param ids
     */

    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin 开始索引
     * @param size 每页显示条数
     * @return
     */
    @Select("select * from o_repertory limit #{begin} , #{size};")
    List<Inventory> selectByPage(@Param("begin") int begin, @Param("size")int size);


    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from o_repertory ")
    int selectTotalCount();


    /**
     * 分页条件查询
     * @param begin 开始索引
     * @param size 每页显示条数
     * @return
     */

    List<Inventory> selectByPageAndCondition(@Param("begin") int begin,@Param("size")int size,@Param("brand")Inventory inventory);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Inventory inventory);

    /**
     * 修改数据
     * @param inventory 品牌对象
     */
    void update(Inventory inventory);

    /**
     * 删除数据
     */
    @Delete("delete from o_repertory where id=#{id}")
    void deleteInventoryById(int id);

}
