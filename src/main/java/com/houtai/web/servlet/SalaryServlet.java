package com.houtai.web.servlet;


import com.alibaba.fastjson.JSON;
import com.houtai.pojo.PageBean;
import com.houtai.pojo.Salary;
import com.houtai.service.SalaryService;
import com.houtai.service.impl.SalaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet("/salary/*")
public class SalaryServlet extends BaseServlet {

    private SalaryService salaryService = new SalaryServiceImpl();

    /**
     * 查询全部数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<Salary> brands = salaryService.selectAll();

        //2. 转为JSON
        String jsonString = JSON.toJSONString(brands);

        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UtF-8");
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为Salary对象
        Salary salary = JSON.parseObject(params, Salary.class);

        //2. 调用service添加
        salaryService.add(salary);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为int[]对象
        int[] ids = JSON.parseObject(params, int[].class);

        //2. 调用service删除
        salaryService.deleteByIds(ids);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     **/
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收 当前页码 和 每页展示条数    通过  url?currentPage=1&pageSize=5  的形式传过来
            String _currentPage = request.getParameter("currentPage");
            String _pageSize = request.getParameter("pageSize");

            int currentPage = Integer.parseInt(_currentPage);
            int pageSize = Integer.parseInt(_pageSize);

        request.setCharacterEncoding("UtF-8");
          //2.调用service查询,将查询结果封装为pageBean对象
            PageBean<Salary> pageBean = salaryService.selectByPage(currentPage, pageSize);

        //3. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //4. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     **/
    public void selectByPageAndCoundition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收 当前页码 和 每页展示条数    通过  url?currentPage=1&pageSize=5  的形式传过来
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        request.setCharacterEncoding("UtF-8");

        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //转为  salary
        Salary salary = JSON.parseObject(params, Salary.class);

        //2.调用service查询,将查询结果封装为pageBean对象
        PageBean<Salary> pageBean = salaryService.selectByPageAndCoundition(currentPage, pageSize,salary);

        //3. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //4. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UtF-8");
        //1.接收修改后的品牌数据
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //将接收过来的id转为int型
        //String _id=request.getParameter("id");
        //int id=Integer.parseInt(_id);

        //将接收过来的JSON数据e对象,转为Brand对象
        Salary _salary = JSON.parseObject(params, Salary.class);

        //将需要修改的内容封装为一个salary对象
        Salary salary = new Salary();
        //brand.setId(id);
        salary.setId(_salary.getId());
        salary.setBasePay(_salary.getBasePay());
        salary.setMeritPay(_salary.getMeritPay());
        salary.setBonus(_salary.getBonus());
        salary.setTotalWages(_salary.getTotalWages());

        //2.调用service方法进行修改
        salaryService.update(salary);

        //3.响应修改成功的标识
        response.getWriter().write("updateSuccess");

    }

    /**
     * 根据id删除对象
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteBrandById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //将接收过来的id转为int型
        String _id=request.getParameter("id");
        int id=Integer.parseInt(_id);


        //2.调用service方法添加
        salaryService.deleteBrandById(id);

        //3.响应添加成功的标识
        response.getWriter().write("deleteSuccess");

    }

}
