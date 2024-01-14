package com.company.cleaningservices.repository;

import com.company.cleaningservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<User> findUserByPhoneNumber(String phoneNumber);
}
