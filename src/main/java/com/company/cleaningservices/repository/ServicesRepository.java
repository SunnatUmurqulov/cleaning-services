package com.company.cleaningservices.repository;

import com.company.cleaningservices.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services,Integer> {
}
