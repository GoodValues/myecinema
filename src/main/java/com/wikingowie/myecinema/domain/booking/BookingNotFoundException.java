package com.wikingowie.myecinema.domain.booking;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(Long id) {
        super(String.format("Booking with given id: [%d] not found", id));
    }
}
