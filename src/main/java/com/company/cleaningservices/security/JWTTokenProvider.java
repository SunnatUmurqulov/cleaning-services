package com.company.cleaningservices.security;

import com.company.cleaningservices.entity.User;
import com.company.cleaningservices.repository.UserRepository;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTTokenProvider {
    private final UserRepository userRepository;
    @Value("${jwt.token.expireTime}")
    private Long expireTime;
    @Value("${jwt.token.secretKey}")
    private String secretKey;

    public String generateJwtToken(String phoneNumber) {
        Date date = new Date();
        return Jwts.builder()
                .setSubject(phoneNumber)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + expireTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expiredJwtException) {
            System.err.println("Expired token");
        } catch (MalformedJwtException malformedJwtException) {
            System.err.println("Broken token");
        } catch (SignatureException signatureException) {
            System.err.println("The key word is error");
        } catch (UnsupportedJwtException unsupportedJwtException) {
            System.err.println("Unused token");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.err.println("An empty token");
        }
        return false;
    }

    public User getUserFromToken(String token) {
        User user = null;
        if (validateToken(token)) {
            String phoneNumber = Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            user = userRepository.findUserByPhoneNumber(phoneNumber).orElse(null);
        }
        return user;
    }
}
