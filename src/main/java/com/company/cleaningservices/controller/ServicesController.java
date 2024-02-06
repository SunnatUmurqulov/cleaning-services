package com.company.cleaningservices.controller;

import com.company.cleaningservices.entity.Services;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.ServiceDTO;
import com.company.cleaningservices.service.CleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServicesController {
    private final CleaningService cleaningService;

    @PostMapping("/addService")
    public HttpEntity<?> addService(@RequestBody ServiceDTO serviceDTO) {
        ApiResponse apiResponse = cleaningService.addServices(serviceDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> update(@RequestBody ServiceDTO serviceDTO, @PathVariable Integer id) {
        ApiResponse apiResponse = cleaningService.update(serviceDTO, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/allServices")
    public Page<Services> allService(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return cleaningService.allService(pageable);
    }


    @GetMapping("/getServices/{id}")
    public HttpEntity<?> getOneService(@PathVariable Integer id){
        return cleaningService.getOneService(id);
    }

    @DeleteMapping("/{service_id}")
    public HttpEntity<?> delete(@PathVariable Integer service_id){
        ApiResponse apiResponse = cleaningService.delete(service_id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
