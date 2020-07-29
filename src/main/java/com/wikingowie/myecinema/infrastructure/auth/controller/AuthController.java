package com.wikingowie.myecinema.infrastructure.auth.controller;

import com.wikingowie.myecinema.domain.user.UserAccountDto;
import com.wikingowie.myecinema.infrastructure.auth.service.AuthService;
import com.wikingowie.myecinema.infrastructure.mapper.UserAccountMappers;
import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.user.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "auth")
public final class AuthController {

    private final AuthService authService;
    private final UserAccountService userAccountService;

    /* admin credentials:
            email: admin@admin.pl
            password: admin

       user credentials:
            email: user@user.pl
            password: user
    */

    @PostMapping(value = "/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@Valid @RequestBody JwtAuthenticationRequest request){
        String jwtToken = authService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken));
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody UserAccountDto dto){
        authService.register(UserAccountMappers.INSTANCE.mapToEntity(dto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/account/{idAccount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccount> getUserAccount(@PathVariable Long idAccount){
        return ResponseEntity.ok(userAccountService.findById(idAccount));
    }


}
