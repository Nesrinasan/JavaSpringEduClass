package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderSpringJPAService {

    private final OrderRepositorySpringJp orderRepositorySpringJp;

    private final ProductService productService;

    private final OrderProductRepository orderProductRepository;

    private final UserService userService;

    private final MailService mailService;

    public OrderSpringJPAService(OrderRepositorySpringJp orderRepositorySpringJp, ProductService productService, OrderProductRepository orderProductRepository, UserService userService, MailService mailService) {
        this.orderRepositorySpringJp = orderRepositorySpringJp;
        this.productService = productService;
        this.orderProductRepository = orderProductRepository;
        this.userService = userService;

        this.mailService = mailService;
    }


    public void save(OrderRequestDto orderRequestDto) {

        List<Long> productIdList = orderRequestDto.getProductIdList();
        String orderDescription = orderRequestDto.getOrderDescription();
        Long userId = orderRequestDto.getUserId();

        Order order = new Order();
        order.setOrderDescription(orderDescription);
        order.setOrderNumber(UUID.randomUUID().toString());
        Optional<Users> userById = userService.findUserById(userId);
        Users users = userById.get();

        productIdList
                .stream()
                .map(productService::findProductById)
                .forEach(product -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(order);
                    orderProduct.setProduct(product);
                    orderProductRepository.save(orderProduct);
                });


        mailService.sendMailUser(order, users);

        System.out.println("");


    }


    public void deleteOrderByOrderNumberCascade(Long orderID) {

        Order order = orderRepositorySpringJp.findById(orderID).get();
        orderRepositorySpringJp.delete(order);

    }

}
