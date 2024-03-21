package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductOrderSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveORderProduct(List<Long> productIdList, Order order) {
        productIdList
                .stream()
                .map(productRepository::findById)
                .forEach(product -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(order);
                    orderProduct.setProduct(product.get());
                    orderProductRepository.save(orderProduct);
                    int numberOfProduct = product.get().getNumberOfProduct();
                    product.get().setNumberOfProduct(--numberOfProduct);
                    productRepository.save(product.get());

                });
    }


    public List<OrderProduct> findAllByOrder(Order order){
        return orderProductRepository.findAllByOrder(order);
    }

}
