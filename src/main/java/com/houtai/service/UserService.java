package com.houtai.service;


import com.houtai.mapper.UserMapper;
import com.houtai.pojo.User;
import com.houtai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法(旧)
     *
     * @param username
     * @param password
     * @return
     */

    public User login(String username, String password) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.select(username, password);

        //释放资源
        sqlSession.close();

        return user;
    }


    /**
     * 注册方法
     *
     * @return
     */

    public boolean register(User user) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if (u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        //u==null 返回true  u!=null 返回false
        return u == null;

    }

    /*用户登录*/
    public User selectA(User user) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user1 = mapper.selectA(user);

        //释放资源
        sqlSession.close();

        return user1;
    }
    /**
     * 修改用户密码
     * @param user
     * @return
     */
    public int updateUser(User user) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        int i = mapper.updateUser(user);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();

        return i;

    }

}
