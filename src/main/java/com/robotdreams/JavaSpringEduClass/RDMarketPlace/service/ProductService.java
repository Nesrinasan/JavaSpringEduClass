package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    public void delete(Long productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);

    }
}
