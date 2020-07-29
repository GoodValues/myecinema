package com.wikingowie.myecinema.infrastructure.location;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public GeoIp getLocation(@RequestParam(value = "ip") String ip) throws IOException, GeoIp2Exception {
        return locationService.getLocation(ip);
    }
}
