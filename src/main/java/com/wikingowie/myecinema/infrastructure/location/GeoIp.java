package com.wikingowie.myecinema.infrastructure.location;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoIp {
    private String ipAddress;
    private String latitude;
    private String longitude;
    private String cityName;
}
