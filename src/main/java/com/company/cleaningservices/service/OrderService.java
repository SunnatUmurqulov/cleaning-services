package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.Orders;
import com.company.cleaningservices.entity.Services;
import com.company.cleaningservices.entity.SubServices;
import com.company.cleaningservices.entity.User;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.OrderDTO;
import com.company.cleaningservices.repository.OrdersRepository;
import com.company.cleaningservices.repository.ServicesRepository;
import com.company.cleaningservices.repository.SubServicesRepository;
import com.company.cleaningservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdersRepository ordersRepository;
    private final ServicesRepository servicesRepository;
    private final SubServicesRepository subServicesRepository;
    private final UserRepository userRepository;
    public HttpEntity<?> addOrder(OrderDTO orderDTO) {
        Optional<Services> optionalServices = servicesRepository.findById(orderDTO.getServicesId());
        if (optionalServices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Service not found",false));
        }

        Optional<User> optionalUser = userRepository.findById(orderDTO.getUserId());
        if (optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found",false));
        }

        Optional<SubServices> optionalSubServices = subServicesRepository.findById(orderDTO.getSubServicesId());
        if (optionalSubServices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("SubService not found", false));
        }

        Orders order = Orders.builder()
                .servicesId(optionalServices.get())
                .subServicesId(optionalSubServices.get())
                .orderDate(Timestamp.valueOf(LocalDateTime.now()))
                .userId(optionalUser.get())
                .build();
        ordersRepository.save(order);
        return ResponseEntity.ok(order);
    }

    public ApiResponse updateOrder(Integer orderId, OrderDTO orderDTO) {
        Optional<Orders> optionalOrders = ordersRepository.findById(orderId);
        if(optionalOrders.isEmpty()){
            return new ApiResponse("order not found",false);
        }

        Optional<Services> optionalServices = servicesRepository.findById(orderDTO.getServicesId());
        if (optionalServices.isEmpty()){
            return new ApiResponse("Service not found",false);
        }

        Optional<User> optionalUser = userRepository.findById(orderDTO.getUserId());
        if (optionalUser.isEmpty()){
            return new ApiResponse("User not found",false);
        }

        Optional<SubServices> optionalSubServices = subServicesRepository.findById(orderDTO.getSubServicesId());
        if (optionalSubServices.isEmpty()){
            return new ApiResponse("SubService not found", false);
        }

        Orders order = optionalOrders.get();
        order.setUserId(optionalUser.get());
        order.setServicesId(optionalServices.get());
        order.setSubServicesId(optionalSubServices.get());
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        ordersRepository.save(order);
        return new ApiResponse("Order updated",true);
    }

    public ApiResponse deleteOrder(Integer orderId) {
        Optional<Orders> optionalOrders = ordersRepository.findById(orderId);
        if (optionalOrders.isEmpty()){
            return new ApiResponse("Order not found",false);
        }
        ordersRepository.deleteById(orderId);
        return new ApiResponse("Order deleted", true);
    }

    public Page<Orders> allOrder(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    public HttpEntity<?> getOrder(Integer order_id) {
        Optional<Orders> optionalOrder = ordersRepository.findById(order_id);
        if (optionalOrder.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
        return ResponseEntity.ok(optionalOrder.get());
    }
}
