package com.ezbytz.api.notification.services;

import com.ezbytz.api.notification.configs.NotificationProperties;
import com.ezbytz.api.notification.models.EmailNotification;
import com.ezbytz.api.notification.models.Template;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Slf4j
@RequiredArgsConstructor
@Service
public class JavaMailNotificationStrategy implements EmailNotificationStrategy {

    private final JavaMailSender emailSender;
    private final NotificationProperties notificationProperties;
    private final Configuration freemarkerConfiguration;

    @Override
    public void send(final EmailNotification notification) {
        log.info("Inside send email notification service: {}", notification);
        final String[] toList = notification.getTo().toArray(String[]::new);
        final String[] ccList = notification.getCc().toArray(String[]::new);
        final String[] bccList = notification.getBcc().toArray(String[]::new);

        final MimeMessage mimeMessage = emailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(notificationProperties.getEmail().getFrom());
            mimeMessageHelper.setTo(toList);
            mimeMessageHelper.setSubject(notification.getTitle());
            mimeMessageHelper.setCc(ccList);
            mimeMessageHelper.setBcc(bccList);
            mimeMessageHelper.setText(getEmailContent(notification), true);
        } catch (final MessagingException | IOException | TemplateException e) {
            log.error("Error sending mail: ", e);
        }
        emailSender.send(mimeMessage);
    }

    private String getEmailContent(final EmailNotification notification) throws IOException, TemplateException {
        final Template template = notification.getTemplate();
        final StringWriter stringWriter = new StringWriter();
        freemarkerConfiguration.getTemplate(template.getName() + ".ftlh").process(template.getVars(), stringWriter);
        return stringWriter.getBuffer().toString();
    }

}
