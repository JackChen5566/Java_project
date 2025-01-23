package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 表示這是一個JPA實體
public class BloodSugar {

    @Id // 指定主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主鍵生成策略
    private Long id;

    // Getter方法獲取id
    public Long getId() {
        return id;
    }

    // Setter方法設置id
    public void setId(Long id) {
        this.id = id;
    }

    private String date; // 記錄日期
    private String time; // 記錄時間
    private String value; // 血糖值

    // Getter方法獲取日期
    public String getDate() {
        return date;
    }

    // Setter方法設置日期
    public void setDate(String date) {
        this.date = date;
    }

    // Getter方法獲取時間
    public String getTime() {
        return time;
    }

    // Setter方法設置時間
    public void setTime(String time) {
        this.time = time;
    }

    // Getter方法獲取血糖值
    public String getValue() {
        return value;
    }

    // Setter方法設置血糖值
    public void setValue(String value) {
        this.value = value;
    }

    // 無參構造方法
    public BloodSugar() {}

    // 全參構造方法
    public BloodSugar(String date, String time, String value) {
        this.date = date;
        this.time = time;
        this.value = value;
    }

    // Getter和Setter方法
}
