package com.wikingowie.myecinema.domain.booking;

import java.util.List;

public interface BookingService {
    void createBooking(Booking booking);
    List<Booking> findAllBooking();
    Booking findOne(Long id);
    void deleteBooking(Long id);
}
