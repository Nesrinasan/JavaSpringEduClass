package com.robotdreams.JavaSpringEduClass.FourthDay.service;

import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.FourthDay.mapper.OrderMapper;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderRepository;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderRepositorySpringJp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {

	private final OrderRepositorySpringJp orderRepositorySpringJp;
	private final JdbcTemplate jdbcTemplate;

	private final OrderRepository orderRepository;

	private final OrderProductRepository orderProductRepository;

	public OrderService(OrderRepositorySpringJp orderRepositorySpringJp, JdbcTemplate jdbcTemplate, OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
		this.orderRepositorySpringJp = orderRepositorySpringJp;
		this.jdbcTemplate = jdbcTemplate;
		this.orderRepository = orderRepository;
		this.orderProductRepository = orderProductRepository;
	}

//	private final JdbcTemplate jdbcTemplate;
//
//	public OrderService(OrderRepository orderRepository, JdbcTemplate jdbcTemplate) {
//		this.orderRepository = orderRepository;
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
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

	@Transactional
	public void deleteOrderByOrderNumber(Long orderID){

	}



}
