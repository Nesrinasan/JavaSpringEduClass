package com.robotdreams.JavaSpringEduClass.FourthDay.service;

import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


	private final JdbcTemplate jdbcTemplate;

	public OrderService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(){



	}


	public List<OrderInfoResponseDto> getOrderByOrderNumber(String orderNumber){

		List<OrderInfoResponseDto> query = jdbcTemplate.query("select * from orders s where s.ORDER_NUMBER = ? ", new Object[]{orderNumber}, new OrderMapper());

		return query;

	}

}
