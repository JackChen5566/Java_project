package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// UserRepository 接口，繼承自 JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
    // 根據用戶名查找用戶
    User findByUsername(String username);
}
