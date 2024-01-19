package com.company.cleaningservices.service;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CategoryDTO;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public ApiResponse addCategory(CategoryDTO categoryDTO) {
        return null;
    }

    public ApiResponse updateCategory(CategoryDTO categoryDTO, Integer id) {
        return null;
    }

    public HttpEntity<?> allCategory() {
        return null;
    }

    public HttpEntity<?> getCategory(Integer id) {
        return null;
    }

    public ApiResponse delete(Integer id) {
        return null;
    }
}
