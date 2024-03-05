package com.robotdreams.JavaSpringEduClass.FourthDay.service;

import com.robotdreams.JavaSpringEduClass.FourthDay.dto.ProductOrderSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Product;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderRepository;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderService {

    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;
    private final OrderRepositorySpringJp orderRepositorySpringJp;


    public ProductOrderService(OrderProductRepository orderProductRepository, ProductRepository productRepository, OrderRepositorySpringJp orderRepositorySpringJp) {
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
        this.orderRepositorySpringJp = orderRepositorySpringJp;
    }

    public void getPRoductByOrderId(Long orderId){

        Order order = orderRepositorySpringJp.findById(orderId).get();

        List<OrderProduct> allByOrder = orderProductRepository.findAllByOrder(order);
        for (OrderProduct orderProduct : allByOrder) {
            Product product = orderProduct.getProduct();
            System.out.printf("product");
        }

    }

    public void getPRoductByOrderIdn1Problem(Long orderId){

        List<OrderProduct> allByOrder = orderProductRepository.findProductOrdersByOrderId(orderId);
        for (OrderProduct orderProduct : allByOrder) {
            Product product = orderProduct.getProduct();
            System.out.printf("product");
        }

    }


    @Transactional
    public void saveOrderProduct(ProductOrderSaveReqestDto productOrderSaveReqestDto){

        String orderDescription = productOrderSaveReqestDto.getOrderDescription();
        Long productId = productOrderSaveReqestDto.getProductId();
        Order order = new Order();
        order.setOrderDescription(orderDescription);
        orderRepositorySpringJp.save(order);
        Product product = new Product();
        product.setCategory("");
        productRepository.save(product);
        //Optional<Product> product = productRepository.findById(productId);
  //      Product product1 = product.get();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setOrder(order);
        orderProductRepository.save(orderProduct);

    }






}
