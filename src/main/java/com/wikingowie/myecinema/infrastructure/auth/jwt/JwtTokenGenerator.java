package com.wikingowie.myecinema.infrastructure.auth.jwt;

import com.auth0.jwt.JWT;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public final class JwtTokenGenerator {

    public static String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));
    }
}
