package com.robotdreams.JavaSpringEduClass.RDMarketPlace.controller;


import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.ProductOrderService;
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


    @GetMapping("/getProductByOrderId")
    public void getPRoductByOrderIdsTEST(@RequestParam Long orderId){
        productOrderService.getPRoductByOrderId(orderId);
    }

}
