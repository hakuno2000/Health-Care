package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User findFirstByUserName(String userName) {
        return userRepo.findFirstByUserName(userName);
    }

    @Override
    public User findFirstByEmail(String email) {
        return userRepo.findFirstByEmail(email);
    }

    @Override
    public User findTopByOrderByUserIDDesc() {
        return userRepo.findTopByOrderByUserIDDesc();
    }

    @Override
    public User findByUserID(Long userID) {
        return userRepo.findByUserID(userID);
    }

    @Override
    public List<User> findByEmailContaining(String email) {
        return userRepo.findByEmailContaining(email);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }
}
