package com.houtai.mapper;


import com.houtai.pojo.Brand;
import com.houtai.pojo.Order;
import com.houtai.pojo.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderListMapper {

    /**
     * 查询所有 1
     *
     * @return
     */
    @Select("select * from orders where ids=#{ids} order by ids desc")
    List<Order> selectAll(Order order);


    /*订单详情 查询根据订单编号id（对应订单详情表orderId）和用户编号id（对应订单详情表ido）*/

    @Select("select * from order_info where ido=#{ids} and orderId=#{id}")
    List<OrderInfo> selectOrderInfo(Order order);

    /**
     * 批量删除
     *
     * @param ids 1
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
     * 删除数据 1
     */
    @Delete("delete from order where id=#{id}")
    void deleteBrandById(int id);

}
