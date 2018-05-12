package com.witt.mapper;

import com.witt.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> queryAll();

    User findUserById(int id);

    User findUserByName(String s);

    void insertUser(User user);

    void deleteUserById(Integer integer);

    void updateUserById(User user);
}
