package com.robotdreams.JavaSpringEduClass.RDMarketPlace.controller;


import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.OrderSpringJPAService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/deleteOrderByOrderId")
    public void deleteOrderByOrderNumber(@RequestParam Long orderID){
        orderSpringJPAService.deleteOrderByOrderNumberCascade(orderID);
    }


    @PostMapping("/retunOorderByOrderId")
    public ResponseEntity<String> retunOorderByOrderId(@RequestParam Long orderID, @RequestParam Long userId){
        String orderReturnMessage = orderSpringJPAService.retunOorderByOrderId(orderID, userId);
        return ResponseEntity.ok().body(orderReturnMessage);
    }


}
