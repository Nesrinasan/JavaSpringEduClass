package com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByCategory(String category);


}
