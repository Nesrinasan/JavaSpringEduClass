package com.robotdreams.JavaSpringEduClass.FourthDay.repository;

import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
