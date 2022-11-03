/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.houtai.mapper;

import com.houtai.pojo.Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InfoMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from u_info")
    List<Info> selectAll();


    /**
     * 添加数据
     *
     * @param info
     */
    @Insert("insert into u_info values(null,#{uname},#{sex},#{number})")
    void add(Info info);


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
    @Select("select * from u_info limit #{begin} , #{size};")
    List<Info> selectByPage(@Param("begin") int begin, @Param("size")int size);


    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from u_info ")
    int selectTotalCount();


    /**
     * 分页条件查询
     * @param begin 开始索引
     * @param size 每页显示条数
     * @return
     */

    List<Info> selectByPageAndCondition(@Param("begin") int begin,@Param("size")int size,@Param("info")Info info);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Info info);

    /**
     * 修改数据
     * @param info 品牌对象
     */
    void update(Info info);

    /**
     * 删除数据
     */
    @Delete("delete from u_info where id=#{id}")
    void deleteInfoById(int id);


}
