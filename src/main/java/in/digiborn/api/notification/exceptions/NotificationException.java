package in.digiborn.api.notification.exceptions;

public class NotificationException extends RuntimeException {

    public NotificationException() {}

    public NotificationException(final String message) {
        super(message);
    }
}
