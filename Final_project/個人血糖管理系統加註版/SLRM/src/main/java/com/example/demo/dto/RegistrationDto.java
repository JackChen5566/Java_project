package com.example.demo.dto;

// RegistrationDto 類，用於接收註冊信息
public class RegistrationDto {
    private String username; // 用戶名
    private String password; // 密碼
    private String email; // 電子郵件
    private String medicalNumber;  // 新增的醫療號字段
    private String phone;  // 新增的電話號碼字段

    // 獲取用戶名
    public String getUsername() {
        return username;
    }

    // 設置用戶名
    public void setUsername(String username) {
        this.username = username;
    }

    // 獲取密碼
    public String getPassword() {
        return password;
    }

    // 設置密碼
    public void setPassword(String password) {
        this.password = password;
    }

    // 獲取電子郵件
    public String getEmail() {
        return email;
    }

    // 設置電子郵件
    public void setEmail(String email) {
        this.email = email;
    }

    // 獲取醫療號碼
    public String getMedicalNumber() {
        return medicalNumber;
    }

    // 設置醫療號碼
    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber;
    }

    // 獲取電話號碼
    public String getPhone() {
        return phone;
    }

    // 設置電話號碼
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
