package com.wikingowie.myecinema.domain.user;

import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_account")
public class UserAccount extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "activation_token")
    private String activationToken;

    @Column(name = "activation_token_expiration_date")
    private LocalDateTime activationTokenExpirationDate;

    @Column(name = "is_account_active")
    private boolean isAccountActive;

    @Column(name = "is_premium_account")
    private boolean isPremiumAccount;

    @Column(name = "is_account_blocked")
    private boolean isAccountBlocked;

    @Column(name = "activation_date")
    private LocalDateTime activationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_data_id")
    private UserData userData;


}
