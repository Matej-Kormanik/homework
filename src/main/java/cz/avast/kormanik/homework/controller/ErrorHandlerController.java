package cz.avast.kormanik.homework.controller;

import cz.avast.kormanik.homework.to.ErrorResponseTO;
import cz.avast.kormanik.homework.to.exception.HomeworkApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.REQUEST_TIMEOUT;

/**
 * Defines methods for handling exceptional state.
 * Methods return http error response based on particular exceptions.
 */
@ControllerAdvice
public class ErrorHandlerController {


    @ExceptionHandler(HomeworkApplicationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorResponseTO> handleApplicationException(HomeworkApplicationException e) {
        ErrorResponseTO errorResponse =
                new ErrorResponseTO(e.getMessage(), BAD_REQUEST.getReasonPhrase(), LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(ResourceAccessException.class)
    @ResponseStatus(REQUEST_TIMEOUT)
    public ResponseEntity<ErrorResponseTO> requestTimeOut(ResourceAccessException e) {
        ErrorResponseTO errorResponse =
                new ErrorResponseTO(e.getMessage(), REQUEST_TIMEOUT.getReasonPhrase(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, REQUEST_TIMEOUT);
    }

}
