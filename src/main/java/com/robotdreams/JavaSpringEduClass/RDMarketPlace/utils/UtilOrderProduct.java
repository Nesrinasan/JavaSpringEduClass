package com.robotdreams.JavaSpringEduClass.RDMarketPlace.utils;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.ProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UtilOrderProduct {

    private final OrderRepositorySpringJp orderRepositorySpringJp;
    private final ProductRepository productRepository;

    private final OrderProductRepository orderProductRepository;

    private final UserRepository userRepository;

    public UtilOrderProduct(OrderRepositorySpringJp orderRepositorySpringJp, ProductRepository productRepository, OrderProductRepository orderProductRepository, UserRepository userRepository) {
        this.orderRepositorySpringJp = orderRepositorySpringJp;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void test() {

        Product product = new Product();
        product.setCategory("phone");
        product.setName("ıphone 15");
        product.setNumberOfProduct(12);
        productRepository.save(product);

        Product product3 = new Product();
        product3.setCategory("phone");
        product3.setName("ıphone 12");
        product3.setNumberOfProduct(11);
        productRepository.save(product3);

        Product product2 = new Product();
        product2.setCategory("tv");
        product2.setNumberOfProduct(23);
        productRepository.save(product2);

        Order order = new Order();
        order.setOrderDescription("order desc1");
        //     orderRepositorySpringJp.save(order);

//        Order order2 = new Order();
//        order2.setOrderDescription("order desc2");

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        orderProductRepository.save(orderProduct);

        Users users = new Users();
        users.setName("NEsrin");
        users.setLastName("Aşan");
        userRepository.save(users);


    }

}
