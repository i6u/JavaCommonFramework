package com.witt;

import com.witt.mapper.UserMapper;
import com.witt.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class CacheTest {
    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    UserMapper userMapper = null;

    @Before
    public void setUp() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = factory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void finish() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void cacheTest() throws Exception {
        User user1 = userMapper.findUserById(1);
        System.out.println(user1.toString());

        /**
         *
         * 执行 update 操作但没有 commit 也会更新缓存内的数据
         *
         * */
        //User user = new User();
        //user.setId(1);
        //user.setUsername("jack");
        //user.setSex("0");
        //user.setBirthday(new Date());
        //user.setAddress("HongKong");
        //userMapper.updateUserById(user);
        //sqlSession.commit();

        User user2 = userMapper.findUserById(1);
        System.out.println(user2.toString());
    }


    @Test
    public void cache2Test() throws Exception {

        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        SqlSession session3 = factory.openSession();

        UserMapper um1 = session1.getMapper(UserMapper.class);
        UserMapper um2 = session2.getMapper(UserMapper.class);
        UserMapper um3 = session3.getMapper(UserMapper.class);

        User user1 = um1.findUserById(1);
        System.out.println(user1.toString());
        session1.close();

        //User user3 = um3.findUserById(1);
        //user3.setUsername("witt");
        //um3.updateUserById(user3);
        //session3.commit();
        //session3.close();

        User user2 = um2.findUserById(1);
        System.out.println(user2.toString());
        session2.close();
    }
}
