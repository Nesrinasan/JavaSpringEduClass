package com.robotdreams.JavaSpringEduClass.FourthDay.service;

import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Product;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderSpringJPAService {

	private final OrderRepositorySpringJp orderRepositorySpringJp;

	private final ProductService productService;

	private final OrderProductRepository orderProductRepository;

	public OrderSpringJPAService(OrderRepositorySpringJp orderRepositorySpringJp, ProductService productService, OrderProductRepository orderProductRepository) {
		this.orderRepositorySpringJp = orderRepositorySpringJp;
		this.productService = productService;
		this.orderProductRepository = orderProductRepository;
	}

	public void save(OrderRequestDto orderRequestDto){

		long productId = orderRequestDto.getProductId();
		String orderDescription = orderRequestDto.getOrderDescription();

		Order order = new Order();
		order.setOrderDescription(orderDescription);
		orderRepositorySpringJp.save(order);

		Product product = productService.findProductById(productId);

		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setOrder(order);
		orderProduct.setProduct(product);

		orderProductRepository.save(orderProduct);

	}




	@Transactional
	public void deleteOrderByOrderNumber(Long orderID){

	}



}
