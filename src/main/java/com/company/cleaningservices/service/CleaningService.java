package com.company.cleaningservices.service;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.ServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CleaningService {
    public ApiResponse addServices(ServiceDTO serviceDTO) {
        return null;
    }

    public ApiResponse update(ServiceDTO serviceDTO, Integer id) {
        return null;
    }

    public HttpEntity<?> allService() {
        return null;
    }

    public HttpEntity<?> getOneService(Integer id) {
        return null;
    }

    public ApiResponse delete(Integer serviceId) {
        return null;
    }
}
