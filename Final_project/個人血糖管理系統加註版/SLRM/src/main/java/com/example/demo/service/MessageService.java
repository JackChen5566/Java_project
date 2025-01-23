package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;

@Service // 表示這是一個服務類別
public class MessageService {

    @Autowired // 自動注入MessageRepository
    private MessageRepository messageRepository;

    // 獲取所有消息，並按時間戳降序排序
    public List<Message> getAllMessages() {
        return messageRepository.findAllByOrderByTimestampDesc();
    }

    // 保存消息
    public void saveMessage(String username, String content) {
        Message message = new Message();
        message.setUsername(username); // 設置消息的用戶名
        message.setContent(content); // 設置消息的內容
        messageRepository.save(message); // 保存消息到數據庫
    }

    // 刪除消息
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id); // 根據ID刪除消息
    }

    // 根據ID獲取消息
    public Message getMessageById(Long id) {
        Optional<Message> message = messageRepository.findById(id); // 查找消息
        return message.orElse(null); // 如果消息存在則返回，否則返回null
    }
    
    // 更新消息內容
    public void updateMessage(Long id, String content) {
        Message message = getMessageById(id); // 根據ID獲取消息
        if (message != null) {
            message.setContent(content); // 設置新的內容
            messageRepository.save(message); // 保存更新後的消息
        }
    }
}
