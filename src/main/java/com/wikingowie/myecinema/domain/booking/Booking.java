package com.wikingowie.myecinema.domain.booking;

import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.seance.Seance;
import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_id")
    private Seance seance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

}
