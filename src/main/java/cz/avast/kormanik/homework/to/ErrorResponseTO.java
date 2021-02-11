package cz.avast.kormanik.homework.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Error http response object.
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseTO {

    private String message;
    private String status;
    private LocalDateTime time;


}
