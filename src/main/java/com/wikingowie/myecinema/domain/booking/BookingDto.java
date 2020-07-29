package com.wikingowie.myecinema.domain.booking;

import com.wikingowie.myecinema.domain.seance.SeanceDto;
import com.wikingowie.myecinema.domain.user.UserAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingDto {

    private SeanceDto seance;
    private UserAccountDto userAccount;

}
