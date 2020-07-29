package com.wikingowie.myecinema.infrastructure.auth.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    @NotNull
    @NotEmpty
    @JsonProperty("email")
    private String username;
    @NotNull
    @NotEmpty
    @JsonProperty("password")
    private String password;

}
