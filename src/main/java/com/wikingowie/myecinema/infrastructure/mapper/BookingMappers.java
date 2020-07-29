package com.wikingowie.myecinema.infrastructure.mapper;

import com.wikingowie.myecinema.domain.booking.Booking;
import com.wikingowie.myecinema.domain.booking.BookingDto;
import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.user.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMappers {

    BookingMappers INSTANCE = Mappers.getMapper(BookingMappers.class);

    BookingDto mapToDto(Booking booking);

    Booking mapToEntity(BookingDto bookingDto);
}
