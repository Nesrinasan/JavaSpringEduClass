package com.robotdreams.JavaSpringEduClass.FourthDay.controller;


import com.robotdreams.JavaSpringEduClass.FourthDay.dto.ProductOrderSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.dto.ProductSaveReqestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.service.ProductOrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductController {

    private final ProductOrderService productOrderService;

    public OrderProductController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("/getProductByOrderId")
        public void getPRoductByOrderId(@RequestParam Long orderId){
        productOrderService.getPRoductByOrderId(orderId);
    }



}
