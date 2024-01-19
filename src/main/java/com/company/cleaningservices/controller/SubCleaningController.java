package com.company.cleaningservices.controller;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.SubServiceDTO;
import com.company.cleaningservices.service.SubCleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sub_services")
@RequiredArgsConstructor
public class SubCleaningController {
    private final SubCleaningService subCleaningService;

    @PostMapping("/add_sub_services")
    public HttpEntity<?> addSubService(@RequestBody SubServiceDTO subServiceDTO) {
        ApiResponse apiResponse = subCleaningService.addSubService(subServiceDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/update_sub_service/{id}")
    public HttpEntity<?> updateSubService(@RequestBody SubServiceDTO subServiceDTO, @PathVariable Integer id) {
        ApiResponse apiResponse = subCleaningService.updateSubService(subServiceDTO, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/delete_sub_service/{id}")
    public HttpEntity<?> deleteSubService(@PathVariable Integer id) {
        ApiResponse apiResponse = subCleaningService.deleteSubService(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/all_sub_service")
    public HttpEntity<?> allSubService() {
        return subCleaningService.allSubService();
    }

    @GetMapping("/get_sub_service/{sub_service_id}")
    public HttpEntity<?> getSubService(@PathVariable Integer sub_service_id) {
        return subCleaningService.getSubService(sub_service_id);
    }


}
