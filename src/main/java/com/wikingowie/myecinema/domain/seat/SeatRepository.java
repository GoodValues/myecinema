package com.wikingowie.myecinema.domain.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SeatRepository extends JpaRepository<Seat, Long> {
}
