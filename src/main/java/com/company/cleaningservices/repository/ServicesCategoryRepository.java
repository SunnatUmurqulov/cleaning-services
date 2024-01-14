package com.company.cleaningservices.repository;

import com.company.cleaningservices.entity.ServicesCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesCategoryRepository extends JpaRepository<ServicesCategory,Integer> {
}
