package com.company.cleaningservices.repository;

import com.company.cleaningservices.entity.ServicesCategory;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesCategoryRepository extends JpaRepository<ServicesCategory,Integer> {
     Page<ServicesCategory> findByCategoryName( Pageable pageable);
}
