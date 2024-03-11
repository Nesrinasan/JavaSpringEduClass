package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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


    public void save(OrderRequestDto orderRequestDto) {

        List<Long> productIdList = orderRequestDto.getProductIdList();
        String orderDescription = orderRequestDto.getOrderDescription();

        Order order = new Order();
        order.setOrderDescription(orderDescription);
        //orderRepositorySpringJp.save(order);

//		for (Long productId : productIdList) {
//			Product product = productService.findProductById(productId);
//			OrderProduct orderProduct = new OrderProduct();
//			orderProduct.setOrder(order);
//			orderProduct.setProduct(product);
//			orderProductRepository.save(orderProduct);
//		}

        /**
         * version 1
         */
//		List<Product> products = productIdList.stream().map(productService::findProductById).toList();
//
//		products.stream().forEach(product -> {
//			OrderProduct orderProduct = new OrderProduct();
//			orderProduct.setOrder(order);
//			orderProduct.setProduct(product);
//			orderProductRepository.save(orderProduct);
//
//		});

        productIdList
                .stream()
                .map(productService::findProductById)
                .forEach(product -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(order);
                    orderProduct.setProduct(product);
                    orderProductRepository.save(orderProduct);
                });

    }


    public void deleteOrderByOrderNumberCascade(Long orderID) {

        Order order = orderRepositorySpringJp.findById(orderID).get();
        orderRepositorySpringJp.delete(order);

    }

}
