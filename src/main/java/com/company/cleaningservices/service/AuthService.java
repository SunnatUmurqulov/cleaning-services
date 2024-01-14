package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.User;
import com.company.cleaningservices.entity.enums.SystemRoleName;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.LoginDTO;
import com.company.cleaningservices.payload.RegisterDTO;
import com.company.cleaningservices.repository.UserRepository;
import com.company.cleaningservices.security.JWTTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTTokenProvider jwtTokenProvider;

    public ApiResponse register(RegisterDTO registerDTO) {
        if (userRepository.existsByPhoneNumber(registerDTO.getPhoneNumber())) {
            return new ApiResponse("Exists by phone number", false);
        }
        User user = new User(
                registerDTO.getFullName(),
                registerDTO.getPassword(),
                passwordEncoder.encode(registerDTO.getPassword()),
                SystemRoleName.SYSTEM_ROLE_USER
        );
        userRepository.save(user);
        return new ApiResponse("User added", true);
    }

    public HttpEntity<?> login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findUserByPhoneNumber(loginDTO.getPhoneNumber());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
           if (passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())){
               String token = jwtTokenProvider.generateJwtToken(user.getPhoneNumber());
               return ResponseEntity.ok(token);
           }
            return ResponseEntity.ok(new ApiResponse("Phone number or password error", false));
        }
        return ResponseEntity.ok(new ApiResponse("No such user exists", false));
    }
}
