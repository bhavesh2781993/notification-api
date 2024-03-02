package in.digiborn.api.notification.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(TemplateFormatException.class)
    public ResponseEntity<ErrorResponse> handleTemplateFormatException(final TemplateFormatException templateFormatException) {
        log.error("Template Format Exception: ", templateFormatException);
        final ErrorResponse errorResponse = new ErrorResponse(templateFormatException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(final DataNotFoundException dataNotFoundException) {
        log.error("Data Not Found Exception: ", dataNotFoundException);
        final ErrorResponse errorResponse = new ErrorResponse(dataNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception exception) {
        log.error("Exception: ", exception);
        final ErrorResponse errorResponse = new ErrorResponse("Internal Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
