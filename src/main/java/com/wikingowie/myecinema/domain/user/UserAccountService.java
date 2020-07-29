package com.wikingowie.myecinema.domain.user;

import com.wikingowie.myecinema.infrastructure.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(UserAccount.class, "email", email));
    }

    public UserAccount findById(long id) {
        return userAccountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(UserAccount.class, "id", String.valueOf(id)));
    }
}
