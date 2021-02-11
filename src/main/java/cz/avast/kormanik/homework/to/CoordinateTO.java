package cz.avast.kormanik.homework.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CoordinateTO {

    private String type;
    private double latitude;
    private double longitude;

}
