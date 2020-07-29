package com.wikingowie.myecinema.domain.booking;

import com.wikingowie.myecinema.infrastructure.mapper.BookingMappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookingController {

    private final BookingService bookingService;
    private final BookingMappers bookingMappers;

    public BookingController(BookingService bookingService, BookingMappers bookingMappers) {
        this.bookingService = bookingService;
        this.bookingMappers = bookingMappers;
    }

    @PostMapping("/bookings")
    public void createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.createBooking(bookingMappers.mapToEntity(bookingDto));
    }

    @GetMapping("/bookings")
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingService.findAllBooking();
        return bookings.stream().
               map(bookingMappers::mapToDto).
               collect(Collectors.toList());
    }

    @GetMapping("/bookings/{id}")
    public BookingDto findOne(@PathVariable Long id) {
        return bookingMappers.mapToDto(bookingService.findOne(id));
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

}
