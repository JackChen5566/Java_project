package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.BloodSugar;

import java.util.List;

// BloodSugarRepository 接口，繼承自 JpaRepository
public interface BloodSugarRepository extends JpaRepository<BloodSugar, Long> {
    // 根據日期範圍查找血糖記錄
    List<BloodSugar> findByDateBetween(String startDate, String endDate);
    
    // 根據日期和時間查找血糖記錄
    BloodSugar findByDateAndTime(String date, String time);
}
