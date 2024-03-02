package in.digiborn.api.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotificationApiApplication {
    public static void main(final String[] args) {
        SpringApplication.run(NotificationApiApplication.class, args);
    }

}
