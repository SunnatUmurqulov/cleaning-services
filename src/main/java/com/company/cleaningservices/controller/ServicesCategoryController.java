package com.company.cleaningservices.controller;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CategoryDTO;
import com.company.cleaningservices.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services_category")
@RequiredArgsConstructor
public class ServicesCategoryController {
    private final CategoryService categoryService;

    @PostMapping("/addCategory")
    public HttpEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        ApiResponse apiResponse = categoryService.addCategory(categoryDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/updateCategory/{id}")
    public HttpEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer id){
        ApiResponse apiResponse = categoryService.updateCategory(categoryDTO,id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/allCategory")
    public HttpEntity<?> allCategory(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return categoryService.allCategory(pageRequest);
    }

    @GetMapping("/allCategory/{id}")
    public HttpEntity<?> getCategory(@PathVariable Integer id){
        return categoryService.getCategory(id);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public HttpEntity<?> deleteCategory(@PathVariable Integer id){
        ApiResponse apiResponse = categoryService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
