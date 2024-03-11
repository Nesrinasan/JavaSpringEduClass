package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductResponseByCategoryDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.mapper.ProductMapper;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
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

    public Optional<List<ProductResponseByCategoryDto>> productListByCategory(String category) {
        List<Product> allByCategory = productRepository.findAllByCategory(category);

        List<ProductResponseByCategoryDto> list = allByCategory.stream().map(product -> {
            ModelMapper modelMapper = new ModelMapper();
            ProductResponseByCategoryDto productResponseByCategoryDto = modelMapper.map(product, ProductResponseByCategoryDto.class);

            return productResponseByCategoryDto;
        }).toList();

        /**
         * Mapstruct
         */
      //  List<ProductResponseByCategoryDto> listMapstruct = allByCategory.stream().map(productMapper::productToProductResponseDtoByCategory).toList();

        return Optional.ofNullable(list);

    }
}
