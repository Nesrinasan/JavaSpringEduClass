package com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
