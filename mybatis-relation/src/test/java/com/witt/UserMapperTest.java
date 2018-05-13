package com.witt;

import com.witt.mapper.OrdersMapperCustom;
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
import java.util.Date;

public class UserMapperTest {

    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    UserMapper userMapper = null;

    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
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
    public void findUserByIdTest() throws Exception {
        User user = userMapper.findUserById(25);
        System.out.println(user);
    }

    @Test
    public void updateUserByIdTest() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        user.setSex("0");
        user.setBirthday(new Date());
        user.setAddress("hong kong");
        userMapper.updateUserById(user);
        sqlSession.commit();
    }
}
