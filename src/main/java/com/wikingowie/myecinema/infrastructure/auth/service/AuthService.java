package com.wikingowie.myecinema.infrastructure.auth.service;

import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.user.UserRole;
import com.wikingowie.myecinema.domain.user.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.wikingowie.myecinema.infrastructure.auth.jwt.JwtTokenGenerator.generateToken;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAccountRepository repository;
    private final AuthenticationManager authenticationManager;

    public String login(String username, String password) {
        authenticate(username, password);
        return generateToken(username);
    }

    public void register(UserAccount userAccount) {
        if (repository.existsByEmail(userAccount.getEmail())) {
            throw new RuntimeException(String.format("Email [%s] already used!", userAccount.getEmail()));
        }
        setupInitialParameters(userAccount);
        repository.save(userAccount);
    }

    private void setupInitialParameters(UserAccount userAccount) {
        userAccount.setUserRole(UserRole.USER);
        userAccount.setActivationToken(UUID.randomUUID().toString());
        userAccount.setActivationTokenExpirationDate(LocalDateTime.now().plusHours(1));
        userAccount.setAccountActive(true);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
