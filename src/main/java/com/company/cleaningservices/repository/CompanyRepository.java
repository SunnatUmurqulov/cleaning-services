package com.company.cleaningservices.repository;

import com.company.cleaningservices.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
