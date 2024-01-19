package com.company.cleaningservices.service;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.SubServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCleaningService {
    public ApiResponse addSubService(SubServiceDTO subServiceDTO) {
        return null;
    }

    public ApiResponse updateSubService(SubServiceDTO subServiceDTO, Integer id) {
        return null;
    }

    public ApiResponse deleteSubService(Integer id) {
        return null;
    }

    public HttpEntity<?> allSubService() {
        return null;
    }

    public HttpEntity<?> getSubService(Integer subServiceId) {
        return null;
    }
}
