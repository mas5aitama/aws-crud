package pandhuta.aws.learning.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResousceNotFoundException extends RuntimeException {
    public ResousceNotFoundException(String message) {
        super(message);
    }
}
