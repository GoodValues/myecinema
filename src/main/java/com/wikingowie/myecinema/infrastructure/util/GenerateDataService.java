package com.wikingowie.myecinema.infrastructure.util;

import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.user.UserRole;
import com.wikingowie.myecinema.domain.user.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class GenerateDataService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    //todo refactor need
    public void generate() {

        UserAccount userAccount = new UserAccount().builder()
                .username("admin")
                .email("admin@admin.pl")
                .password(passwordEncoder.encode("admin"))
                .userRole(UserRole.ADMIN)
                .registrationDate(LocalDateTime.now())
                .activationToken("activation_token")
                .activationTokenExpirationDate(LocalDateTime.of(2020,1,1,1,1,1))
                .isAccountActive(true)
                .isPremiumAccount(true)
                .isAccountBlocked(false)
                .activationDate(LocalDateTime.of(2020,1,1,1,1,1))
                .version(1)
                .creationDate(LocalDate.now())
                .lastUpdateDate(LocalDate.now())
                .build();

        UserAccount userAccount2 = new UserAccount().builder()
                .username("user")
                .email("user@user.pl")
                .password(passwordEncoder.encode("user"))
                .userRole(UserRole.USER)
                .registrationDate(LocalDateTime.now())
                .activationToken("activation_token")
                .activationTokenExpirationDate(LocalDateTime.now())
                .isAccountActive(true)
                .isPremiumAccount(true)
                .isAccountBlocked(false)
                .activationDate(LocalDateTime.now())
                .version(1)
                .creationDate(LocalDate.now())
                .lastUpdateDate(LocalDate.now())
                .build();

        userAccountRepository.save(userAccount);
        userAccountRepository.save(userAccount2);
    }
}
