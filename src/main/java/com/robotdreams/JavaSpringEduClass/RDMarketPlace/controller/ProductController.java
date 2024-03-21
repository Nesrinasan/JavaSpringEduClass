package com.robotdreams.JavaSpringEduClass.RDMarketPlace.controller;


import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductResponseByCategoryDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public void save(@RequestBody ProductSaveReqestDto productSaveReqestDto) {
        productService.save(productSaveReqestDto);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long productId) {
        productService.delete(productId);
    }

    @GetMapping("/productListByCategory/{category}")
    public ResponseEntity<List<ProductResponseByCategoryDto>> productListByCategory(@PathVariable String category){
        Optional<List<ProductResponseByCategoryDto>> productResponseByCategoryDtos = productService.productListByCategory(category);

        if (productResponseByCategoryDtos.isPresent()){
            List<ProductResponseByCategoryDto> productResponseByCategoryDtos1 = productResponseByCategoryDtos.get();
            return ResponseEntity.ok(productResponseByCategoryDtos1);
        }
        return ResponseEntity.notFound().build();

    }

}
