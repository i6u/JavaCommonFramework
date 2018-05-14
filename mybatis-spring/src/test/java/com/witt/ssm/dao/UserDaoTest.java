package com.witt.ssm.dao;

import com.witt.ssm.BaseTest;
import com.witt.ssm.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryByIdTest() {
        User user = userDao.queryById(1);
        System.out.println(user);
    }
}
