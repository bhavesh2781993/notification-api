package in.digiborn.api.notification.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import in.digiborn.api.notification.exceptions.ClientNotFoundException;
import in.digiborn.api.notification.exceptions.DataNotFoundException;
import in.digiborn.api.notification.exceptions.NotificationException;
import in.digiborn.api.notification.exceptions.TemplateFormatException;
import in.digiborn.api.notification.models.responses.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<ErrorResponse> handleNotificationException(final NotificationException notificationException) {
        log.error("Notification Exception: ", notificationException);
        final ErrorResponse errorResponse = new ErrorResponse(notificationException.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler({TemplateFormatException.class, ClientNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleTemplateFormatException(final RuntimeException runtimeException) {
        log.error("Template Format Exception: ", runtimeException);
        final ErrorResponse errorResponse = new ErrorResponse(runtimeException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(final DataNotFoundException dataNotFoundException) {
        log.error("Data Not Found Exception: ", dataNotFoundException);
        final ErrorResponse errorResponse = new ErrorResponse(dataNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public void handleResourceNotFoundException(final NoResourceFoundException e) {
        log.info("NoResourceFoundException: {}", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception exception) {
        log.error("Exception: ", exception);
        final ErrorResponse errorResponse = new ErrorResponse("Internal Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
