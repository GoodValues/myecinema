package com.wikingowie.myecinema.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {

    private String title;
    private String type;
    private String production;
    private LocalDate releaseYear;
    private String director;
    private int duration;
    private int forHowManyYears;

}
