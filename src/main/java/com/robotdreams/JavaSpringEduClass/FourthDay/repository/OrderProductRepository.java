package com.robotdreams.JavaSpringEduClass.FourthDay.repository;

import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.OrderProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
//
//    List<OrderProduct> findAllByOrder(Order order);
//
//
    @Query("SELECT po FROM OrderProduct po WHERE po.order.id = :orderId")
    List<OrderProduct> findProductOrdersByOrderId(Long orderId);


    List<OrderProduct> findAllByOrder(Order order);


}
