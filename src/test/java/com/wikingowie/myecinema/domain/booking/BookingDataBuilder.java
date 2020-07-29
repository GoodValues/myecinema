package com.wikingowie.myecinema.domain.booking;

import com.wikingowie.myecinema.domain.cinema.Cinema;
import com.wikingowie.myecinema.domain.hall.Hall;
import com.wikingowie.myecinema.domain.movie.Movie;
import com.wikingowie.myecinema.domain.seance.Seance;
import com.wikingowie.myecinema.domain.user.UserAccount;

import java.sql.Time;
import java.time.LocalDate;

public class BookingDataBuilder {

    public static Booking prepareBooking() {
        Movie movie = Movie.builder().
                director("Frank Darabont").
                duration(2).
                forHowManyYears(21).
                production("USA").
                releaseYear(LocalDate.of(1999, 12, 6)).
                title("Zielona mila").
                type("dramat")
                .build();
        Hall hall = Hall.builder().
                hallNumber(3)
                .build();
        Cinema cinema = Cinema.builder().
                adress("Zielona 38").
                cinemaType("Helios").
                city("Bialystok").
                postcode("15-030").
                build();
        Seance seance = Seance.builder().
                cinema(cinema).
                day(LocalDate.now().plusDays(5)).
                hall(hall).
                movie(movie).
                languageVersion("PL").
                showingTime(new Time(System.currentTimeMillis())).
                build();
        UserAccount user = UserAccount.builder().
                email("test@gmail.com").
                username("Jan Kowalski").
                build();
        return  Booking.builder().
                seance(seance).
                userAccount(user).
                build();
    }

}
