package com.company.cleaningservices.controller;

import com.company.cleaningservices.payload.OrderDTO;
import com.company.cleaningservices.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping("/add-order")
    public HttpEntity<?> addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }

    @GetMapping("/all-order")
    public HttpEntity<?> allOrder(){
        return orderService.allOrder();
    }

    @GetMapping("/get-order")
    public HttpEntity<?> getOrder(){
        return orderService.getOrder();
    }


    @DeleteMapping("/delete-order/{order_id}")
    public HttpEntity<?> deleteOrder(@PathVariable Integer order_id){
        return orderService.deleteOrder(order_id);
    }

    @PutMapping("/update-order/{order_Id}")
    public HttpEntity<?> updateOrder(@PathVariable Integer order_Id,@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(order_Id,orderDTO);
    }
}
