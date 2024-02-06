package com.company.cleaningservices.controller;

import com.company.cleaningservices.entity.Company;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CompanyDTO;
import com.company.cleaningservices.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.PageRequest.of;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/add_company")
    public HttpEntity<?> addCompany(@RequestBody CompanyDTO companyDTO) {
        ApiResponse apiResponse = companyService.addCompany(companyDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/update_company/{company_id}")
    public HttpEntity<?> updateCompany(@RequestBody CompanyDTO companyDTO, @PathVariable Integer company_id) {
        ApiResponse apiResponse = companyService.updateCompany(companyDTO,company_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{delete_company_id}")
    public HttpEntity<?> deleteCompany(@PathVariable Integer delete_company_id){
        ApiResponse apiResponse = companyService.deleteCompany(delete_company_id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/all_company")
    public Page<Company> allCompany(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = of(page, size);
        return companyService.allCompany(pageRequest);
    }

    @GetMapping("/{get_company_id}")
    public HttpEntity<?> getCompany(@PathVariable Integer get_company_id){
        return companyService.getCompany(get_company_id);
    }
}
