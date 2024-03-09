package in.digiborn.api.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaAuditing
@SpringBootApplication
public class NotificationApiApplication {
    public static void main(final String[] args) {
        SpringApplication.run(NotificationApiApplication.class, args);
    }

}
