package com.wikingowie.myecinema.domain.ticket;

import com.wikingowie.myecinema.domain.booking.Booking;
import com.wikingowie.myecinema.domain.seat.Seat;
import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @Column(name="ticket_type")
    private String ticketType;

    @Column(name="price")
    private BigDecimal price;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
