package com.houtai.mapper;


import com.houtai.pojo.Admin;
import com.houtai.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface AdminMapper {


    /**
     * 根据用户名查询用户对象
     *
     * @param username
     * @return
     */
    @Select("select * from u_admin where username = #{username}")
    Admin select(String username);

    /*管理员登录*/
    @Select("select * from u_admin where username = #{username} and password = #{password}")
    Admin adminLogin(Admin admin);


    /*管理员修改密码*/
    @Update("update u_admin set password=#{pass} where id=#{id} and password=#{password}")
    int updateAdmin(Admin admin);
}



