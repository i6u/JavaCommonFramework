package com.witt.ssm.dao;

import com.witt.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User queryById(@Param("id") int id);

    List<User> queryAll();
}
