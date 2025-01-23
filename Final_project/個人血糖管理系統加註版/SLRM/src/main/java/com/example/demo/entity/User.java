package com.example.demo.entity;

import jakarta.persistence.*;

@Entity // 表示這是一個JPA實體類
@Table(name = "users") // 設置對應的表名為 "users"
public class User {

    @Id // 指定這是主鍵字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主鍵生成策略，使用自動增量
    private Long id;

    private String username; // 用戶名

    private String password; // 密碼

    private String email; // 電子郵件
    
    private String medicalNumber;  // 新增的醫療號字段
    
    private String phone;  // 新增的電話號碼字段
    
    @Column(name = "role") // 指定該字段在數據庫中的列名為 "role"
    private String role = "User"; // 用戶角色，默認為 "User"

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

    // Getter方法獲取密碼
    public String getPassword() {
        return password;
    }

    // Setter方法設置密碼
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter方法獲取電子郵件
    public String getEmail() {
        return email;
    }

    // Setter方法設置電子郵件
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter方法獲取醫療號碼
    public String getMedicalNumber() {
        return medicalNumber;
    }

    // Setter方法設置醫療號碼
    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber;
    }

    // Getter方法獲取電話號碼
    public String getPhone() {
        return phone;
    }

    // Setter方法設置電話號碼
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter方法獲取角色
    public String getRole() {
        return role;
    }

    // Setter方法設置角色
    public void setRole(String role) {
        this.role = role;
    }
}
