package com.robotdreams.JavaSpringEduClass.FourthDay.controller;


import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
