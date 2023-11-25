package in.digiborn.api.notification.services;

import in.digiborn.api.notification.models.EmailNotification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailNotificationManager {
    
    private final EmailNotificationContext emailNotificationContext;
    private final JavaMailNotificationStrategy javaMailNotificationStrategy;
    
    public void send(final EmailNotification emailNotification) {
        emailNotificationContext.setEmailNotificationStrategy(javaMailNotificationStrategy);
        emailNotificationContext.send(emailNotification);
    }
    
}
