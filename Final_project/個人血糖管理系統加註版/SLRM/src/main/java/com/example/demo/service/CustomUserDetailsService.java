package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // 表示這是一個服務類別
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired // 自動注入UserRepository
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根據用戶名查找用戶
        User user = userRepository.findByUsername(username);
        if (user == null) {
            // 如果用戶不存在，拋出異常
            throw new UsernameNotFoundException("用戶不存在: " + username);
        }

        // 構建並返回UserDetails實例
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) 
                .roles("USER")
                .build();
    }
}
