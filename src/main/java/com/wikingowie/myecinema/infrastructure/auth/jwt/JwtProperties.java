package com.wikingowie.myecinema.infrastructure.auth.jwt;

public class JwtProperties {
    static final String SECRET = "Secret";
    static final int EXPIRATION_TIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
}
