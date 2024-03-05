package com.robotdreams.JavaSpringEduClass.FourthDay.controller;


import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderInfoResponseDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.FourthDay.entity.Order;
import com.robotdreams.JavaSpringEduClass.FourthDay.service.OrderSpringJPAService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderSpringJPAService orderSpringJPAService;

    public OrderController(OrderSpringJPAService orderSpringJPAService) {
        this.orderSpringJPAService = orderSpringJPAService;
    }
//
//
//    @GetMapping("/getOrderByOrderNumber")
//    public List<OrderInfoResponseDto> getOrderByOrderNumber(@RequestParam String orderNumber){
//        return orderService.getOrderByOrderNumber(orderNumber);
//    }

    @PostMapping("/save")
    public void save(@RequestBody OrderRequestDto orderRequestDto){
        orderSpringJPAService.save(orderRequestDto);
    }
//
//    @GetMapping("/getOrderByOrderNumberOrm")
//    public List<Order> getOrderByOrderNumberOrm(@RequestParam String orderNumber){
//        return orderService.getOrderByOrderNumberOrm(orderNumber);
//    }
//
//    @DeleteMapping("/deleteOrderByOrderNumber")
//    public void deleteOrderByOrderNumber(@RequestParam Long orderID){
//        orderService.deleteOrderByOrderNumber(orderID);
//    }
//
//
//    @DeleteMapping("/deleteOrderByOrderNumberOrphanRemoval")
//    public void deleteOrderByOrderNumberOrphanRemoval(@RequestParam Long orderID){
//        orderService.deleteOrderByOrderNumber(orderID);
//    }

}
