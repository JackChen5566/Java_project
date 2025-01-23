package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BloodSugar;
import com.example.demo.repository.BloodSugarRepository;

@Service // 表示這是一個服務類別
public class RecordService {

    @Autowired // 自動注入BloodSugarRepository
    private BloodSugarRepository bloodSugarRepository;

    // 保存血糖記錄
    public void saveRecord(BloodSugar bloodSugar) {
        bloodSugarRepository.save(bloodSugar);
    }

    // 查找指定日期範圍內的血糖記錄
    public List<BloodSugar> findRecordsByDateRange(String startDate, String endDate) {
        return bloodSugarRepository.findByDateBetween(startDate, endDate);
    }

    // 更新血糖記錄
    public void updateRecord(BloodSugar bloodSugar) {
        // 確認有相同日期和時間的記錄
        BloodSugar existingRecord = bloodSugarRepository.findByDateAndTime(bloodSugar.getDate(), bloodSugar.getTime());
        if (existingRecord != null) {
            // 更新現有記錄
            existingRecord.setValue(bloodSugar.getValue());
            bloodSugarRepository.save(existingRecord);
        } else {
            // 創建新記錄
            bloodSugarRepository.save(bloodSugar);
        }
    }

    // 根據ID獲取記錄的方法
    public BloodSugar getRecordById(Long id) {
        return bloodSugarRepository.findById(id).orElse(null);
    }

    // 根據ID更新記錄的方法
    public void updateRecordById(Long id, String value) {
        BloodSugar record = bloodSugarRepository.findById(id).orElse(null);
        if (record != null) {
            record.setValue(value);
            bloodSugarRepository.save(record);
        } else {
            throw new RuntimeException("Record not found for id: " + id);
        }
    }
}
