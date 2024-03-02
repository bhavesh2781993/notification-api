package in.digiborn.api.notification.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import in.digiborn.api.notification.models.EmailNotification;
import in.digiborn.api.notification.models.EmailRecipient;
import in.digiborn.api.notification.models.enums.NotificationType;
import in.digiborn.api.notification.services.EmailNotificationManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailNotificationControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private EmailNotificationManager emailNotificationManager;

    @Test
    @Disabled
    void testSendEmail() {
        final EmailNotification emailNotification = EmailNotification.builder()
            .notificationType(NotificationType.EMAIL_NOTIFICATION)
            .title("test-title")
            .to(List.of(EmailRecipient.builder().emailId("receiver-to@gmail.com").build()))
            .cc(List.of(EmailRecipient.builder().emailId("receiver-cc@gmail.com").build()))
            .bcc(List.of(EmailRecipient.builder().emailId("receiver-bcc@gmail.com").build()))
            .build();

        final ResponseEntity<Void> response =
            testRestTemplate.postForEntity("/email/send", emailNotification, Void.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

}