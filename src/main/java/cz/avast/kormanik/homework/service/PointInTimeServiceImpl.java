package cz.avast.kormanik.homework.service;


import cz.avast.kormanik.homework.to.CoordinateTO;
import cz.avast.kormanik.homework.to.PersonCoordinatesTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.SocketTimeoutException;


@Slf4j
@Service
public class PointInTimeServiceImpl implements PointInTimeService {

    private static final String SOURCE = "vip-db";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cord.api.url}")
    private String cordApiUrl;


    @Override
    public PersonCoordinatesTO getPointInTimeCords(final Integer pointInTime) {
        final String url = cordApiUrl + pointInTime;
        log.info("Sending request to {}", url);

        try {
            ResponseEntity<CoordinateTO> coordinate = restTemplate.getForEntity(url, CoordinateTO.class);
            return new PersonCoordinatesTO(SOURCE, coordinate.getBody());
        } catch (Exception e) {
            log.error("Could not fetch resource for {}", url);
        }
        return null;
    }



}
