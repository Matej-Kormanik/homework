package cz.avast.kormanik.homework.controller;

import cz.avast.kormanik.homework.service.IPointInTimeService;
import cz.avast.kormanik.homework.service.PointInTimeService;
import cz.avast.kormanik.homework.to.CoordinateTO;
import cz.avast.kormanik.homework.to.PersonCoordinatesTO;
import cz.avast.kormanik.homework.to.TimeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1")
public class Controller {

    private final IPointInTimeService pointInTimeService;

    @Autowired
    public Controller(PointInTimeService pointInTimeService) {
        this.pointInTimeService = pointInTimeService;
    }


    @GetMapping("/now")
    public ResponseEntity<TimeTO> currentTime() {
        TimeTO time = new TimeTO(LocalDateTime.now());
        return ResponseEntity.ok(time);
    }


    @GetMapping("/VIP/{pointInTime}")
    public ResponseEntity<PersonCoordinatesTO> personCoordinates(@PathVariable final Integer pointInTime) {
        CoordinateTO coordinate = pointInTimeService.getPointInTimeCords(pointInTime);
        return null;
    }

}
