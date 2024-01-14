package com.company.cleaningservices.payload;

import lombok.Data;

@Data
public class LoginDTO {
    private String phoneNumber;
    private String password;
}
