package com.robotdreams.JavaSpringEduClass.FourthDay.controller;


import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrderByOrderNumber")
    public List<OrderInfoResponseDto> getOrderByOrderNumber(@RequestParam String orderNumber){
        return orderService.getOrderByOrderNumber(orderNumber);
    }


}
