package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.User;

public interface UserService {
    User findFirstByUserName(String userName);
    User findFirstByEmail(String email);
    void save(User user);
    void delete(User user);
}
