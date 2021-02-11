package cz.avast.kormanik.homework.service;

import cz.avast.kormanik.homework.to.CoordinateTO;
import cz.avast.kormanik.homework.to.PersonCoordinatesTO;
import cz.avast.kormanik.homework.to.exception.HomeworkApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

/** Implementation of {@link PointInTimeService}. */
@Slf4j
@Service
public class PointInTimeServiceImpl implements PointInTimeService {

    private static final String SOURCE = "vip-db";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String cordApiUrl;


    @Override
    public PersonCoordinatesTO getPointInTimeGps(final Integer pointInTime) {
        final String url = cordApiUrl + pointInTime;
        log.info("Sending request to {}", url);
        try {
            ResponseEntity<CoordinateTO> coordinate = restTemplate.getForEntity(url, CoordinateTO.class);
            return new PersonCoordinatesTO(SOURCE, coordinate.getBody());
        } catch (ResourceAccessException e) {
            log.error("Getting a resource from {} took too long", url);
            throw new ResourceAccessException(format("Getting a resource from %s took too long", url));
        } catch (Exception e) {
            log.error("Could not fetch resource for {}", url);
            throw new HomeworkApplicationException(e.getMessage());
        }
    }

}
