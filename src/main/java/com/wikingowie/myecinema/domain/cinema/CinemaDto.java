package com.wikingowie.myecinema.domain.cinema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaDto {

    private String cinemaType;
    private String city;
    private String postcode;
    private String adress;

}
