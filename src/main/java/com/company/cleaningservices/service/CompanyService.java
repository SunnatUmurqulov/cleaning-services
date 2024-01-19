package com.company.cleaningservices.service;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CompanyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    public ApiResponse addCompany(CompanyDTO companyDTO) {
        return null;
    }

    public ApiResponse updateCompany(CompanyDTO companyDTO, Integer companyId) {
        return null;
    }

    public ApiResponse deleteCompany(Integer deleteCompanyId) {
        return null;
    }

    public HttpEntity<?> allCompany() {
        return null;
    }

    public HttpEntity<?> getCompany(Integer getCompanyId) {
        return null;
    }
}
