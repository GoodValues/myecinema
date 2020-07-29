package com.wikingowie.myecinema.domain.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BookingRepository extends JpaRepository<Booking, Long> {
}
