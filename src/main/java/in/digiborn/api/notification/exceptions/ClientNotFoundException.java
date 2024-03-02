package in.digiborn.api.notification.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(final String message) {
        super(message);
    }
}
