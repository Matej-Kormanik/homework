package cz.avast.kormanik.homework.service;


import cz.avast.kormanik.homework.to.CoordinateTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PointInTimeService implements IPointInTimeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cord.api.url}")
    private String cordApiUrl;


    @Override
    public CoordinateTO getPointInTimeCords(final Integer pointInTime) {
        CoordinateTO coordinate = restTemplate
                .getForObject(cordApiUrl.concat(String.valueOf(pointInTime)), CoordinateTO.class);
        return coordinate;
    }



}
