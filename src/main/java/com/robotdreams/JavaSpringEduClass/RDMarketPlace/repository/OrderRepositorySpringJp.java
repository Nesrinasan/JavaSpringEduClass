package com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositorySpringJp extends CrudRepository<Order, Long> {





}
