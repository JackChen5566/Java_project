package com.example.demo.repository;

import com.example.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// MessageRepository 接口，繼承自 JpaRepository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // 查找所有消息，並按時間戳降序排序
    List<Message> findAllByOrderByTimestampDesc();
}
