package com.wikingowie.myecinema.domain.seat;

import com.wikingowie.myecinema.domain.hall.Hall;
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
@Table(name = "seat")
public class Seat extends BaseEntity {

    @Column(name="place")
    private int place;

    @Column(name="row")
    private int row;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "halls_id")
    private Hall hall;
}
