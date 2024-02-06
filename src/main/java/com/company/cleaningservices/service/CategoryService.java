package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.ServicesCategory;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CategoryDTO;
import com.company.cleaningservices.repository.ServicesCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ServicesCategoryRepository servicesCategoryRepository;
    public ApiResponse addCategory(CategoryDTO categoryDTO) {
        ServicesCategory servicesCategory = ServicesCategory.builder()
                .categoryName(categoryDTO.getCategoryName())
                .build();
        servicesCategoryRepository.save(servicesCategory);
        return new ApiResponse("Category added",true);
    }

    public ApiResponse updateCategory(CategoryDTO categoryDTO, Integer id) {
        Optional<ServicesCategory> optionalServicesCategory = servicesCategoryRepository.findById(id);
        if (optionalServicesCategory.isEmpty()){
            return new ApiResponse("Category not found",false);
        }
        ServicesCategory category = optionalServicesCategory.get();
        category.setCategoryName(categoryDTO.getCategoryName());
        servicesCategoryRepository.save(category);
        return new ApiResponse("Category updated",true);
    }

    public HttpEntity<?> allCategory(Pageable pageable) {
        servicesCategoryRepository.findAll(pageable);
        return null;
    }

    public HttpEntity<?> getCategory(Integer id) {
        Optional<ServicesCategory> categoryOptional = servicesCategoryRepository.findById(id);
        if (categoryOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Category not found",false));
        }
        return ResponseEntity.ok(categoryOptional.get());
    }

    public ApiResponse delete(Integer id) {
        Optional<ServicesCategory> optionalServicesCategory = servicesCategoryRepository.findById(id);
        if (optionalServicesCategory.isEmpty()){
            return new ApiResponse("Category not found",false);
        }
        servicesCategoryRepository.deleteById(id);
        System.out.println("test");
        System.out.println("test2");
        return new ApiResponse("Deleted",true);
    }
}
