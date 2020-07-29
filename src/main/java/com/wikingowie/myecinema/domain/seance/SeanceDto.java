package com.wikingowie.myecinema.domain.seance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wikingowie.myecinema.domain.cinema.CinemaDto;
import com.wikingowie.myecinema.domain.hall.HallDto;
import com.wikingowie.myecinema.domain.movie.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeanceDto {

    private String languageVersion;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate day;
    private Time showingTime;
    private HallDto hall;
    private MovieDto movie;
    private CinemaDto cinema;

}
