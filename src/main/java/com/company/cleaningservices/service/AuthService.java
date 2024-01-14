package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.User;
import com.company.cleaningservices.entity.enums.SystemRoleName;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.LoginDTO;
import com.company.cleaningservices.payload.RegisterDTO;
import com.company.cleaningservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public ApiResponse register(RegisterDTO registerDTO) {
        if (userRepository.existsByPhoneNumber(registerDTO.getPhoneNumber())) {
            return new ApiResponse("Exists by phone number", false);
        }
        User user = new User(
               registerDTO.getFullName(),
                registerDTO.getPassword(),
                registerDTO.getPhoneNumber(),
                SystemRoleName.SYSTEM_ROLE_USER
        );
        userRepository.save(user);
        return new ApiResponse("User added", true);
    }

    public HttpEntity<?> login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findUserByPhoneNumber(loginDTO.getPhoneNumber());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (user.getPassword().equals(loginDTO.getPassword())){
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.ok(new ApiResponse("Phone number or password error",false));
        }
        return ResponseEntity.ok(new ApiResponse("No such user exists",false));
    }
}
