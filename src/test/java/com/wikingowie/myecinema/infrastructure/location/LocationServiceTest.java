package com.wikingowie.myecinema.infrastructure.location;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationServiceTest {

    private static final String IP = "94.124.1.66";
    private static final String CITY = "Krakow";
    private static final String LATITUDE = "50.0631";
    private static final String LONGITUDE = "19.9701";
    private static final String dbLocation = "geolocation/GeoLite2-City.mmdb";
    private LocationServiceImpl locationService;

    @BeforeEach
    public void setUp() throws IOException {
        locationService = new LocationServiceImpl(dbLocation);
    }

    @Test
    public void shouldReturnDetailsWhenGiveIpAddress() throws IOException, GeoIp2Exception {

        //when
        GeoIp result = locationService.getLocation(IP);
        //then
        assertThat(CITY).isEqualTo(result.getCityName());
        assertThat(LONGITUDE).isEqualTo(result.getLongitude());
        assertThat(LATITUDE).isEqualTo(result.getLatitude());
    }

}
