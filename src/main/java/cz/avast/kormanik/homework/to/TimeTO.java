package cz.avast.kormanik.homework.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TimeTO {

    private LocalDateTime now;

}
