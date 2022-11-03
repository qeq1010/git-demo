package com.houtai.mapper;


import com.houtai.pojo.Salary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SalaryMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from u_salary")
    List<Salary> selectAll();

    /**
     * 添加数据
     *
     * @param salary
     */
    @Insert("insert into u_salary values(null,#{name},#{basePay},#{meritPay},#{bonus},#{totalWages})")
    void add(Salary salary);


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
    @Select("select * from u_salary limit #{begin} , #{size};")
    List<Salary> selectByPage(@Param("begin") int begin,@Param("size")int size);


    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from u_salary ")
    int selectTotalCount();


    /**
     * 分页条件查询
     * @param begin 开始索引
     * @param size 每页显示条数
     * @return
     */
    List<Salary> selectByPageAndCondition(@Param("begin") int begin,@Param("size")int size,@Param("salary")Salary salary);


    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Salary salary);

    /**
     * 修改数据
     * @param salary 品牌对象
     */
    void update(Salary salary);

    /**
     * 删除数据
     */
    @Delete("delete from u_salary where id=#{id}")
    void deleteBrandById(int id);

}
