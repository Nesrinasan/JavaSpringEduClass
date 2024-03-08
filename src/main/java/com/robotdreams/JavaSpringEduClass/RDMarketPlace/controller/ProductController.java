package com.robotdreams.JavaSpringEduClass.RDMarketPlace.controller;


import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public void save(@RequestBody ProductSaveReqestDto productSaveReqestDto){
        productService.save(productSaveReqestDto);
    }

    @DeleteMapping()
    public void delete(@RequestParam Long productId){
        productService.delete(productId);

    }



}
