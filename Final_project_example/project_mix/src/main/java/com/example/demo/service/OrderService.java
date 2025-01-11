package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderItem;
import com.example.demo.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	public void saveOrder(Long carId,String carName,String customerName,String phone) {
		OrderItem orderItem = new OrderItem();
		orderItem.setCarId(carId);
		orderItem.setCarName(carName);
		orderItem.setCustomerName(customerName);
		orderItem.setPhone(phone);
		orderRepository.save(orderItem);
		
	}

}
