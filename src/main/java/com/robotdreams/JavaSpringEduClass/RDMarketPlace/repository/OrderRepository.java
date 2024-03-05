package com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void saveOrder(String orderNumber) {
      Order order = new Order();
      order.setOrderNumber(orderNumber);

      entityManager.merge(order);

      System.out.printf("");

    }

    public List<Order> findOrderByOrderNumber(String orderNumber) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);

        Root<Order> orderRoot = cq.from(Order.class);
        cq.select(orderRoot).where(cb.equal(orderRoot.get("orderNumber"), orderNumber));

        return entityManager.createQuery(cq).getResultList();
    }

}
