package engine;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class Exeptionhandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleNotFoundFlight(Exception e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
