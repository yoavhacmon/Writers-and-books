package yoav.Writers.and.books.advice;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import yoav.Writers.and.books.Exceptions.LibraryCustomException;

@RestController
@ControllerAdvice
public class LibraryControllerAdvice {
    @ExceptionHandler(value = {LibraryCustomException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionDetails handleException(Exception exception){
        return new ExceptionDetails("error", exception.getMessage());
    }
}
