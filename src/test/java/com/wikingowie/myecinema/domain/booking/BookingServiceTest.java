package com.wikingowie.myecinema.domain.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private Booking booking;

    @Captor
    ArgumentCaptor<Booking> captor;

    @BeforeEach
    public void setUp() {
        booking = BookingDataBuilder.prepareBooking();
    }

    @Test
    public void findCustomerById() {
        //given
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        //when
        Booking actual = bookingService.findOne(1L);
        //then
        assertThat(actual.getSeance()).isEqualTo(booking.getSeance());
        assertThat(actual.getUserAccount()).isEqualTo(booking.getUserAccount());

    }

    @Test
    public void shouldThrowExceptionWhenBookingIsNull() {
        //given
        when(bookingRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        //when
        BookingNotFoundException thrown =
                assertThrows(BookingNotFoundException.class,
                        () -> bookingService.findOne(1L));
        //then
        assertEquals(thrown.getMessage(), "Booking with given id: [1] not found");

    }

    @Test
    public void findAllBookings() {
        //given
        List<Booking> bookingsList = Arrays.asList(booking);
        when(bookingRepository.findAll()).thenReturn(bookingsList);
        //when
        List<Booking> actual = bookingService.findAllBooking();
        //then
        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0).getSeance().getDay()).isEqualTo(bookingsList.get(0).getSeance().getDay());
        assertThat(actual.get(0).getUserAccount().getEmail()).isEqualTo(bookingsList.get(0).getUserAccount().getEmail());

    }

    @Test
    public void deleteBooking() {
        doNothing().when(bookingRepository).deleteById(anyLong());
        bookingService.deleteBooking(1L);
    }

    @Test
    public void createBooking() {
        //when
        bookingService.createBooking(booking);
        //then
        verify(bookingRepository).save(captor.capture());

        assertThat(booking.getSeance()).isEqualTo(captor.getValue().getSeance());
        assertThat(booking.getUserAccount()).isEqualTo(captor.getValue().getUserAccount());
        assertThat(booking.getCreationDate()).isEqualTo(captor.getValue().getCreationDate());

    }

}
