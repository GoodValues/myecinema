package com.wikingowie.myecinema.domain.booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findOne(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
