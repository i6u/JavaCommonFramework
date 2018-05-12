package com.witt.dao;

import com.witt.pojo.User;

public interface IUser {

    User queryAll();

    User findUserById(Integer integer);

    User findUserByName(String s);

    void insertUser(User user);

    void deleteUserById(Integer integer);

    void updateUserById(User user);
}
