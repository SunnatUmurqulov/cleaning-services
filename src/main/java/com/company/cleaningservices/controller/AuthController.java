package com.company.cleaningservices.controller;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.LoginDTO;
import com.company.cleaningservices.payload.RegisterDTO;
import com.company.cleaningservices.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        ApiResponse apiResponse = authService.register(registerDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
       return authService.login(loginDTO);
    }
}
