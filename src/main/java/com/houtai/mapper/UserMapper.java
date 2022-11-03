package com.houtai.mapper;


import com.houtai.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {

    /**
     * 根据用户名和密码查询用户对象
     *
     * @param username
     * @param password
     * @return
     */
    @Select("select * from u_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     *
     * @param username
     * @return
     */
    @Select("select * from u_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户
     *
     * @param user
     */
    @Insert("insert into u_user(username,password) values(#{username},#{password})")
    void add(User user);

    /*用户登录*/
    @Select("select * from u_user where username = #{username} and password = #{password}")
    User selectA(User user);
//    @Update("update u_user set password=#{password} where username=#{username}")
//    User update(@Param("username") String username, @Param("password")  String password);

    /*用户修改密码*/
    @Update("update u_user set password=#{pass} where id=#{id} and password=#{password}")
    int updateUser(User user);
}



