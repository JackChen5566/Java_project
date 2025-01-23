package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAllMessages() {
		return messageRepository.findAllByOrderByTimestampDesc();
	}

	public void saveMessage(String username, String content) {
		Message message = new Message();
		message.setUsername(username);
		message.setContent(content);
		messageRepository.save(message);

	}

	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
	}

	public Message getMessageById(Long id) {
		Optional<Message> message = messageRepository.findById(id);
		return message.orElse(null);

	}
	
	public void updateMessage(Long id, String content) {
		Message message = getMessageById(id);
		if (message !=null) {
			message.setContent(content);
			messageRepository.save(message);
		}
		
	}

}
