package com.wikingowie.myecinema.domain.cinema;

import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cinema")
public class Cinema extends BaseEntity {

    @Column (name="cinema_type")
    private String cinemaType;

    @Column (name="city")
    private String city;

    @Column (name="postcode")
    private String postcode;

    @Column (name="adress")
    private String adress;
}
