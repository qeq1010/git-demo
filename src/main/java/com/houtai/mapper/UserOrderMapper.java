package com.houtai.mapper;


import com.houtai.pojo.Brand;
import com.houtai.pojo.OrderShop;
import com.houtai.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserOrderMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from o_order where ids=#{id}")
    List<Brand> selectAll(Brand brand);

    /**
     * 添加数据
     *
     * @param brand
     */
    @Insert("insert into o_order(userName,fname,price,ids) values(#{userName},#{fname},#{price},#{id})")
    void add(Brand brand);
    /**
     * 批量删除
     *
     * @param ids
     */

    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 修改数据
     * @param brand 品牌对象
     */
    void update(Brand brand);

    /**
     * 删除数据
     */
    @Delete("delete from o_order where id=#{id}")
    void deleteBrandById(int id);

}
