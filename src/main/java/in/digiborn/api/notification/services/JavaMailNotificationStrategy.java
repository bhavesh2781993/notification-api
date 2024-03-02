package in.digiborn.api.notification.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import in.digiborn.api.notification.configs.NotificationProperties;
import in.digiborn.api.notification.models.EmailNotification;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Slf4j
@RequiredArgsConstructor
@Service
public class JavaMailNotificationStrategy implements EmailNotificationStrategy {

    private final JavaMailSender emailSender;
    private final NotificationProperties notificationProperties;

    @Override
    public void send(final EmailNotification notification) {
        log.info("Inside send email notification service: {}", notification);
        final String[] toList = notification.getToEmailIds().toArray(String[]::new);
        final String[] ccList = notification.getCCEmailIds().toArray(String[]::new);
        final String[] bccList = notification.getBCCEmailIds().toArray(String[]::new);

        final MimeMessage mimeMessage = emailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(notificationProperties.getEmail().getFrom());
            mimeMessageHelper.setSubject(notification.getTitle());
            mimeMessageHelper.setTo(toList);
            mimeMessageHelper.setCc(ccList);
            mimeMessageHelper.setBcc(bccList);
            mimeMessageHelper.setText(notification.getBody(), true);
        } catch (final MessagingException e) {
            log.error("Error sending mail: ", e);
        }
        emailSender.send(mimeMessage);
    }

}
