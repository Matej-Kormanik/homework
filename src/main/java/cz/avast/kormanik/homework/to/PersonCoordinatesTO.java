package cz.avast.kormanik.homework.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class PersonCoordinatesTO {

    private String source;

    private CoordinateTO gpsCoords;


    public PersonCoordinatesTO() {
    }
}
