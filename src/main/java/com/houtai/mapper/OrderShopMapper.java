package com.houtai.mapper;


import com.houtai.pojo.Brand;
import com.houtai.pojo.OrderShop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderShopMapper {

    /*新,查询在售*/
    @Select("select * from order_shop")
    List<OrderShop> selectAllOrder();

    //添加购物车
    //*先查询购物车是否有订单*//
    @Select("select * from order_cat where ido= #{id} and fname=#{fname}")
    OrderShop selectByShop(OrderShop orderShop);


    //*购物车添加数据*//
    @Insert("insert into order_cat(fname,price,ido) values(#{fname},#{price},#{id})")
    void addShop(OrderShop orderShop);

    //*购物车有数据num+1*//
    @Insert("update order_cat set num=num+1 where fname = #{fname}")
    int updateShop(OrderShop orderShop);


/*

    *//*清购物车商品*//*
    @Delete("delete from order_info where id=#{id}")
    void deleteOrderById(int id);


    *//*清空购物车*//*
    @Delete("delete from order_info where ido=#{id}")
    void deleteOrderAll(int id);*/
}
