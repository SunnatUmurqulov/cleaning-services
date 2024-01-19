package com.company.cleaningservices.service;

import com.company.cleaningservices.payload.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    public HttpEntity<?> addOrder(OrderDTO orderDTO) {
        return null;
    }

    public HttpEntity<?> deleteOrder(Integer orderId) {
        return null;
    }

    public HttpEntity<?> updateOrder(Integer orderId, OrderDTO orderDTO) {
        return null;
    }

    public HttpEntity<?> allOrder() {
        return null;
    }

    public HttpEntity<?> getOrder() {
        return null;
    }
}
