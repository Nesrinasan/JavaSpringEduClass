package com.robotdreams.JavaSpringEduClass.FourthDay.service;

import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderMapper;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	private final JdbcTemplate jdbcTemplate;

	public OrderService(OrderRepository orderRepository, JdbcTemplate jdbcTemplate) {
		this.orderRepository = orderRepository;
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(String orderNumber){

		orderRepository.saveOrder(orderNumber);

	}

	public List<OrderInfoResponseDto> getOrderByOrderNumber(String orderNumber){

		List<OrderInfoResponseDto> query = jdbcTemplate.query("select * from orders s where s.ORDER_NUMBER = ? ", new Object[]{orderNumber}, new OrderMapper());

		return query;

	}

	public List<Order> getOrderByOrderNumberOrm(String orderNumber){
		return orderRepository.findOrderByOrderNumber(orderNumber);
	}

}
