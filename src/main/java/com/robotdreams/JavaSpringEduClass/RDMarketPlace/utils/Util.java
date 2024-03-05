package com.robotdreams.JavaSpringEduClass.RDMarketPlace.utils;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Util {

    private final OrderRepositorySpringJp orderRepositorySpringJp;
    private final ProductRepository productRepository;

    private final OrderProductRepository orderProductRepository;

    public Util(OrderRepositorySpringJp orderRepositorySpringJp, ProductRepository productRepository, OrderProductRepository orderProductRepository) {
        this.orderRepositorySpringJp = orderRepositorySpringJp;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

  //  @PostConstruct
    public void test(){
        Order order = new Order();
        order.setOrderDescription("sdf");


        Product product = new Product();
        product.setCategory("dsd");

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        orderProductRepository.save(orderProduct);


    }

    public void test2(){
        Order order = new Order();
        order.setOrderDescription("sdf");
        order = orderRepositorySpringJp.save(order);

        Product product = new Product();
        product.setCategory("dsd");
        product = productRepository.save(product);

        OrderProduct orderProduct = new OrderProduct();
        order = orderRepositorySpringJp.findById(order.getId()).get();
        orderProduct.setOrder(order);
        product = productRepository.findById(product.getId()).get();
        orderProduct.setProduct(product);
        orderProductRepository.save(orderProduct);


    }

}
