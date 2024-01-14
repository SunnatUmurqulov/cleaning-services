package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.enums.SystemRoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private SystemRoleName systemRoleName;

    public User(String fullName, String password, String phoneNumber, SystemRoleName systemRoleName) {
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.systemRoleName = systemRoleName;
    }
}
