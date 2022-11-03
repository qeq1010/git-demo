package com.houtai.mapper;


import com.houtai.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from o_order order by id desc")
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand
     */
    @Insert("insert into o_order values(null,#{userName},#{fname},#{price},#{status})")
    void add(Brand brand);


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
    @Select("select * from o_order limit #{begin} , #{size};")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size")int size);


    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from o_order ")
    int selectTotalCount();


    /**
     * 分页条件查询
     * @param begin 开始索引
     * @param size 每页显示条数
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size")int size,@Param("brand")Brand brand);


    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

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
