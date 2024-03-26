package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;
    private final OrderService orderService;

    public void getPRoductByOrderId(Long orderId){

        Order order = orderService.findById(orderId);

        System.out.println(order);

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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveORderProduct(List<Long> productIdList, Order order) {
        productIdList
                .stream()
                .map(productService::findProductById)
                .forEach(product -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(order);
                    orderProduct.setProduct(product);
                    orderProductRepository.save(orderProduct);
                    int numberOfProduct = product.getNumberOfProduct();
                    product.setNumberOfProduct(--numberOfProduct);
                    productService.saveProduct(product);
                    System.out.println(order);

                });
    }


    public List<OrderProduct> findAllByOrder(Order order){
        return orderProductRepository.findAllByOrder(order);
    }

}
