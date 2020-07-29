package com.wikingowie.myecinema.infrastructure.location;

import java.io.IOException;
import com.maxmind.geoip2.exception.GeoIp2Exception;

public interface LocationService {
    GeoIp getLocation(String ip) throws IOException, GeoIp2Exception;
}
