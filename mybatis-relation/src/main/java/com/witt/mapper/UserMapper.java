package com.witt.mapper;

import com.witt.pojo.User;

public interface UserMapper {
    User findUserById(int id) throws Exception;

    void updateUserById(User user) throws Exception;
}
