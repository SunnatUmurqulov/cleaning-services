package com.company.cleaningservices.controller;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CleaningTypesDTO;
import com.company.cleaningservices.service.CleaningTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cleaning_types")
@RequiredArgsConstructor
public class CleaningTypesController {
    private final CleaningTypesService cleaningTypesService;

    @PostMapping("/addType")
    public HttpEntity<?> addType(@RequestBody CleaningTypesDTO cleaningTypesDTO){
        ApiResponse apiResponse = cleaningTypesService.addType(cleaningTypesDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/update/{type_id}")
    public HttpEntity<?> update(@RequestBody CleaningTypesDTO cleaningTypesDTO, @PathVariable Integer type_id){
        ApiResponse apiResponse = cleaningTypesService.update(cleaningTypesDTO,type_id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/allTypes")
    public HttpEntity<?> allCleaningTypes(){
        return cleaningTypesService.allTypes();
    }


    @GetMapping("/{type_id}")
    public HttpEntity<?> getCleaningType(@PathVariable Integer type_id){
        return cleaningTypesService.getCleaningType(type_id);
    }

    @DeleteMapping("/{deleteType_id}")
    public HttpEntity<?> delete(@PathVariable Integer deleteType_id){
        return cleaningTypesService.delete(deleteType_id);
    }
}
