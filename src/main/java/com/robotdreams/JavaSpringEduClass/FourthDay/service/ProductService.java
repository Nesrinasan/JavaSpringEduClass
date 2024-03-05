package com.robotdreams.JavaSpringEduClass.FourthDay.service;

import com.robotdreams.JavaSpringEduClass.FourthDay.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Product;
import com.robotdreams.JavaSpringEduClass.FourthDay.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductSaveReqestDto productSaveReqestDto){

        Product product = new Product();
        product.setCategory(productSaveReqestDto.getCategory());
        product.setName(productSaveReqestDto.getName());
        productRepository.save(product);

    }

    public Product findProductById(Long id){
        return productRepository.findById(id).get();
    }


}
