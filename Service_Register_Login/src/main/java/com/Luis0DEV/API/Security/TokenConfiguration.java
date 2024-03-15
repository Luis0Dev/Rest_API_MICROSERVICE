package com.Luis0DEV.API.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenConfiguration {

    @Value("api.security.token.secret")
    private String secret;
    public String generateToken(User user){

        try{
            Algorithm algorithm = Algorithm.HMAC512(secret);
            String token;
            token = JWT.create()
                    .withIssuer("auth_api_service")
                    .withSubject(user.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception){
            throw new RuntimeException("Error While Generation Token", exception);
        }
    }

    public String validateToken(String token){

        try{
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return  JWT.require(algorithm)
                    .withIssuer("auth_api_service")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (JWTCreationException exception){
            return "";
        }
    }

    private Instant genExpirationDate(){

        return LocalDateTime.now().plusHours(0).toInstant(ZoneOffset.of("-3:00"));
    }
}
