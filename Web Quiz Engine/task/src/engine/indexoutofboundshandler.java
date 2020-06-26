package engine;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class indexoutofboundshandler {
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity handleNotFoundFlight(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
