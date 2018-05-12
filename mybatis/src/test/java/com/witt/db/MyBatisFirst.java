package com.witt.db;

import com.witt.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class MyBatisFirst {

    private static SqlSessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        String resource = "mybatis-config.xml";
        try {
            //通过配置文件获取连接数据库连接信息
            Reader reader = Resources.getResourceAsReader(resource);

            //通过配置信息来构建一个SqlSessionFactory
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryAll() {
        //通过SqlSessionFactory打开一个会话
        SqlSession openSession = sessionFactory.openSession();

        try {
            List<User> userList = openSession.selectList("queryAll");
            printUserList(userList);
        } finally {
            //关闭session会话
            openSession.close();
        }
    }

    private void printUserList(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByIdTest() {
        SqlSession openSession = sessionFactory.openSession();

        try {
            User user = openSession.selectOne("findUserById", 2);
            System.out.println(user);
        } finally {
            //关闭session会话
            openSession.close();
        }
    }


    @Test
    public void findUserByNameTest() {
        SqlSession openSession = sessionFactory.openSession();

        try {
            List<User> users = openSession.selectList("findUserByName", "qq");
            printUserList(users);
        } finally {
            //关闭session会话
            openSession.close();
        }
    }


    @Test
    public void insertUserTest() {
        SqlSession openSession = sessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("jack");
            user.setPassword("123456");
            user.setSex("1");
            user.setNick_name("张三");
            user.setRegister_date(new Date());
            openSession.insert("insertUser", user);
            openSession.commit();
            System.out.println("id : " + user.getId());
        } finally {
            openSession.close();
        }
    }

    @Test
    public void deleteUserByIdTest() {
        SqlSession openSession = sessionFactory.openSession();
        try {
            openSession.delete("deleteUserById", 17);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void updateUserByIdTest() {
        SqlSession openSession = sessionFactory.openSession();
        try {
            User user = new User();
            user.setId(18);
            user.setUsername("small");
            user.setPassword("123456");
            user.setSex("0");
            user.setNick_name("小蜜蜂");
            user.setRegister_date(new Date());
            openSession.update("updateUserById", user);
            openSession.commit();
            //System.out.println("id : " + user.getId());
        } finally {
            openSession.close();
        }
    }
}
