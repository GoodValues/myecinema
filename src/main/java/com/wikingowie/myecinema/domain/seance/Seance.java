package com.wikingowie.myecinema.domain.seance;

import com.wikingowie.myecinema.domain.cinema.Cinema;
import com.wikingowie.myecinema.domain.hall.Hall;
import com.wikingowie.myecinema.domain.movie.Movie;
import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "seance")
public class Seance extends BaseEntity {

    @Column(name = "language_version")
    private String languageVersion;

    @Column(name = "day")
    private LocalDate day;

    @Column(name = "showing_time")
    private Time showingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
}
