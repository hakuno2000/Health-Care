package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findFirstByUserName(String userName);
    User findFirstByEmail(String email);
    User findTopByOrderByUserIDDesc();
    User findByUserID(Long userID);
    List<User> findByEmailContaining(String email);
}
