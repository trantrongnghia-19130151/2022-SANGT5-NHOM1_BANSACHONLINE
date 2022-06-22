package com.bansach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansach.entities.OrderDetail;
import com.bansach.repository.OrderDetailRepository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	public void saveOrder(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
	}
	
}
