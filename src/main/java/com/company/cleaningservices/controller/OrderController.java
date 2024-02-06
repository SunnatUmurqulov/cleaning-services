package com.company.cleaningservices.controller;

import com.company.cleaningservices.entity.Orders;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.OrderDTO;
import com.company.cleaningservices.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping("/add-order")
    public HttpEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    @GetMapping("/all-order")
    public Page<Orders> allOrder(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return orderService.allOrder(pageRequest);
    }

    @GetMapping("/get-order/{order_id}")
    public HttpEntity<?> getOrder(@PathVariable Integer order_id) {
        return orderService.getOrder(order_id);
    }


    @DeleteMapping("/delete-order/{order_id}")
    public ApiResponse deleteOrder(@PathVariable Integer order_id) {
        return orderService.deleteOrder(order_id);
    }

    @PutMapping("/update-order/{order_Id}")
    public ApiResponse updateOrder(@PathVariable Integer order_Id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(order_Id, orderDTO);
    }
}
