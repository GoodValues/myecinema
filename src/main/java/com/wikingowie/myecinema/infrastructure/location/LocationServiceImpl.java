package com.wikingowie.myecinema.infrastructure.location;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class LocationServiceImpl implements LocationService {

    private String locationFilepath;
    private final DatabaseReader dbReader;

    public LocationServiceImpl(@Value("${geolocation.filepath}") String locationFilepath) throws IOException {
        this.locationFilepath = locationFilepath;
        this.dbReader = initDatabaseReader();
    }

    private DatabaseReader initDatabaseReader() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File database = new File(classLoader.getResource(locationFilepath).getFile());;
        return new DatabaseReader.Builder(database).build();
    }

    @Override
    public GeoIp getLocation(String ip) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse cityResponse = dbReader.city(ipAddress);

        return GeoIp.builder()
                .ipAddress(ip)
                .cityName(cityResponse.getCity().getName())
                .latitude(cityResponse.getLocation().getLatitude().toString())
                .longitude(cityResponse.getLocation().getLongitude().toString())
                .build();
    }
}
