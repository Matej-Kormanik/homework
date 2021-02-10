package cz.avast.kormanik.homework.service;

import cz.avast.kormanik.homework.to.CoordinateTO;

public interface IPointInTimeService {

    CoordinateTO getPointInTimeCords(final Integer pointInTime);

}
