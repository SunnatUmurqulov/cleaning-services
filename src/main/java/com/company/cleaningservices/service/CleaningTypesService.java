package com.company.cleaningservices.service;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CleaningTypesDTO;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class CleaningTypesService {
    public ApiResponse addType(CleaningTypesDTO cleaningTypesDTO) {
        return null;
    }

    public ApiResponse update(CleaningTypesDTO cleaningTypesDTO, Integer typeId) {
        return null;
    }

    public HttpEntity<?> allTypes() {
        return null;
    }

    public HttpEntity<?> getCleaningType(Integer typeId) {
        return null;
    }

    public HttpEntity<?> delete(Integer deleteTypeId) {
        return null;
    }
}
