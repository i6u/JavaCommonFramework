package com.witt.mapper;

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
import java.util.List;

public class UserMapperTest {
    SqlSession session;
    UserMapper userMapper;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void end() {
        if (session != null) {
            session.close();
        }
    }

    @Test
    public void queryAll() {

        List<User> users = userMapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();

    }

    @Test
    public void queryOne() {
        User user = userMapper.findUserById(18);
        System.out.println(user);
    }

    @Test
    public void insterUser() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123456");
        user.setSex("1");
        user.setNick_name("small bee");
        user.setRegister_date(new Date());

        userMapper.insertUser(user);
        session.commit();
        System.out.println(user.getId());
    }

    @Test
    public void delete() {
        userMapper.deleteUserById(28);
        session.commit();
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(18);
        user.setUsername("bee");
        user.setPassword("123456");
        user.setSex("1");
        user.setNick_name("Little bee");
        user.setRegister_date(new Date());
        userMapper.updateUserById(user);
        session.commit();
    }
}
