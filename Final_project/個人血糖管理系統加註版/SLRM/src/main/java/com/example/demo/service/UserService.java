package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // 表示這是一個服務類別
public class UserService {

    @Autowired // 自動注入UserRepository
    private UserRepository userRepository;

    @Autowired // 自動注入PasswordEncoder
    private PasswordEncoder passwordEncoder;

    // 保存用戶
    public void saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword()); // 加密用戶的密碼
        user.setPassword(encodedPassword); // 設置加密後的密碼
        userRepository.save(user); // 保存用戶到數據庫
    }
    
    // 根據用戶名查找用戶
    public User findByUsername(String username) {
        return userRepository.findByUsername(username); // 查找並返回用戶
    }
}
