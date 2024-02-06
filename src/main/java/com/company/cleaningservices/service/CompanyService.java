package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.Company;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.CompanyDTO;
import com.company.cleaningservices.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public ApiResponse addCompany(CompanyDTO companyDTO) {
        Company company = new Company(
                companyDTO.getName(),
                companyDTO.getPhoneNumber(),
                companyDTO.getAddress()
        );
        companyRepository.save(company);
        return new ApiResponse("Company added", true);
    }

    public ApiResponse updateCompany(CompanyDTO companyDTO, Integer companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isEmpty()) {
            return new ApiResponse("Company id not found", false);
        }
        Company company = optionalCompany.get();
        company.setName(companyDTO.getName());
        company.setPhoneNumber(companyDTO.getPhoneNumber());
        company.setAddress(companyDTO.getAddress());
        companyRepository.save(company);
        return new ApiResponse("Company updated", true);
    }

    public ApiResponse deleteCompany(Integer deleteCompanyId) {
        Optional<Company> optionalCompany = companyRepository.findById(deleteCompanyId);
        if (optionalCompany.isEmpty()) {
            return new ApiResponse("Company id not found", false);
        }
        companyRepository.deleteById(deleteCompanyId);
        return new ApiResponse("Company deleted", true);
    }

    public Page<Company> allCompany(PageRequest pageRequest) {
        return companyRepository.findAll(pageRequest);
    }

    public HttpEntity<?> getCompany(Integer companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Company id not found", false));
        }
        return ResponseEntity.ok(optionalCompany.get());
    }
}
