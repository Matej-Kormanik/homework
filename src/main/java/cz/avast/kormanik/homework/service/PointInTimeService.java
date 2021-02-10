package cz.avast.kormanik.homework.service;

import cz.avast.kormanik.homework.to.PersonCoordinatesTO;

public interface PointInTimeService {

    PersonCoordinatesTO getPointInTimeCords(final Integer pointInTime);

}
