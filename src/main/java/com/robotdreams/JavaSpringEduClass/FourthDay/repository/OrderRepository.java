package com.robotdreams.JavaSpringEduClass.FourthDay.repository;

import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Ordersss;
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
    public List<Ordersss> findOrderByOrderNumber(String name) {

        return null;
    }

    @Transactional
    public Ordersss saveOrder() {
        return null;

    }
}
