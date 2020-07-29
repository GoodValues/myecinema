package com.wikingowie.myecinema.domain.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
