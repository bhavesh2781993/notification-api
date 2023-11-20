package com.ezbytz.api.notification.exceptions.handlers;

import com.ezbytz.api.notification.exceptions.NotificationException;
import com.ezbytz.api.notification.models.responses.ErrorResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<ErrorResponse> handleNotificationException(final NotificationException notificationException) {
        log.error("Notification Exception: ", notificationException);
        final ErrorResponse errorResponse = new ErrorResponse(notificationException.getMessage());
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception exception) {
        log.error("Exception: ", exception);
        final ErrorResponse errorResponse = new ErrorResponse("Internal Error");
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorResponse);
    }

}
