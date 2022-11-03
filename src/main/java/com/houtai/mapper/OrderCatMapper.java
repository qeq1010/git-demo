package com.houtai.mapper;

import com.houtai.pojo.Order;
import com.houtai.pojo.OrderCat;
import com.houtai.pojo.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderCatMapper {


    //*查询购物车*//
    @Select("select * from order_cat where ido=#{id}")
    List<OrderCat> selectOrderCat(OrderCat orderCat);

    /**
     * 删除数据
     */
    @Delete("delete from order_cat where id=#{id}")
    void deleteOrderCatById(int id);


    //批量删除
    void deleteByIds(@Param("ids") int[] ids);


        //*清空购物车引用批量删除*//*

    /*订单详情表添加数据*/
    void addOrderInfo (@Param("orderInfos") List<OrderInfo> orderInfos);

    /*订单表添加数据*/
    @Insert("insert into orders(orderId,cartTotalPrice,cartTotalCount,ids) values(#{orderId},#{cartTotalPrice},#{cartTotalCount},#{ids})")
    Order addOrder(Order order);




}
