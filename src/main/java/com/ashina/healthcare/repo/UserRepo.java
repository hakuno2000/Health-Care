package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findFirstByUserName(String userName);
    User findFirstByEmail(String email);
}
