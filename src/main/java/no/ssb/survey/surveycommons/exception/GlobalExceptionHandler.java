package no.ssb.survey.surveycommons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {

        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false), notFound);
        return new ResponseEntity<>(errorDetails, notFound);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<ErrorDetails> handleResourceExistsException(ResourceExistsException exception, WebRequest request) {
        HttpStatus conflict = HttpStatus.CONFLICT;
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false), conflict);
        return new ResponseEntity<>(errorDetails, conflict);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorDetails> handleAPIException(APIException exception, WebRequest request) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false), badRequest);
        return new ResponseEntity<>(errorDetails, badRequest);
    }


    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest request) {

        HttpStatus methodNotAllowed = HttpStatus.METHOD_NOT_ALLOWED;
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false), methodNotAllowed);
        return new ResponseEntity<>(errorDetails, methodNotAllowed);
    }

    @ExceptionHandler(ResourceValidationException.class)
    public ResponseEntity<ErrorDetails> handleValidationException(ResourceValidationException exception, WebRequest request) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false), badRequest);
        return new ResponseEntity<>(errorDetails, badRequest);
    }
}
