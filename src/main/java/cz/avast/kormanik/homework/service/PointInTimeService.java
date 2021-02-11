package cz.avast.kormanik.homework.service;

import cz.avast.kormanik.homework.to.PersonCoordinatesTO;

/**
 * Provides interface for fetching gps coordinates from external service.
 */
public interface PointInTimeService {

    /**
     * Fetch gps coordinates for given point-in-time fetched from external service.
     *
     * @param pointInTime point-in-time represented as Integer.
     * @return {@link PersonCoordinatesTO} object containing gps coordination.
     */
    PersonCoordinatesTO getPointInTimeGps(Integer pointInTime);
}
