package com.company.cleaningservices.payload;

import lombok.Data;

@Data
public class RegisterDTO {
    private String fullName;
    private String phoneNumber;
    private String password;
}
