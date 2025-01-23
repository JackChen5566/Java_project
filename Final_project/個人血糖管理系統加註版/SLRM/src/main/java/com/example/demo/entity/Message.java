package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 表示這是一個JPA實體類
public class Message {
    
    @Id // 指定這是主鍵字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主鍵生成策略，使用自動增量
    private Long id;
    
    private String username; // 發消息的用戶名
    private String content; // 消息內容
    private LocalDateTime timestamp = LocalDateTime.now(); // 消息的時間戳，默認為當前時間

    // Getter方法獲取id
    public Long getId() {
        return id;
    }

    // Setter方法設置id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter方法獲取用戶名
    public String getUsername() {
        return username;
    }

    // Setter方法設置用戶名
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter方法獲取消息內容
    public String getContent() {
        return content;
    }

    // Setter方法設置消息內容
    public void setContent(String content) {
        this.content = content;
    }

    // Getter方法獲取時間戳
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter方法設置時間戳
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
