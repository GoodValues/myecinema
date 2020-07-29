package com.wikingowie.myecinema.infrastructure.auth.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        Credentials credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), Credentials.class);
        } catch (IOException e) {
            System.out.println("Error during parsing input stream");
        }

        validateCredentials(credentials);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());

        return authenticationManager.authenticate(authenticationToken);
    }

    private void validateCredentials(Credentials credentials) {
        if (credentials == null || credentials.getUsername() == null || credentials.getPassword() == null)
            throw new RuntimeException("Username or password not provided");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
@NoArgsConstructor
@Data
class Credentials {
    @JsonProperty("email")
    private String username;
    @JsonProperty("password")
    private String password;
}


