package com.houtai.service;

import com.houtai.mapper.AdminMapper;
import com.houtai.pojo.Admin;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class AdminService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*管理员登录*/
    public Admin adminLogin(Admin admin) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        //4. 调用方法
        Admin admin1 = mapper.adminLogin(admin);

        //释放资源
        sqlSession.close();

        return admin1;
    }

    /**
     * 修改管理员密码
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);


        int i = mapper.updateAdmin(admin);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();

        return i;

    }


}
