package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.User;

import java.util.List;

public interface UserService {
    User findFirstByUserName(String userName);
    User findFirstByEmail(String email);
    User findTopByOrderByUserIDDesc();
    User findByUserID(Long userID);
    List<User> findByEmailContaining(String email);
    List<User> findPatientByEmailContaining(String email);
    void save(User user);
    void delete(User user);
}
