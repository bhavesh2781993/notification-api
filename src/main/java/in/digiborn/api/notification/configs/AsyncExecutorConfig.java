package in.digiborn.api.notification.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncExecutorConfig {
    private static final int EMAIL_QUEUE_CAPACITY = 500;

    @Bean(name = "asyncEmailExecutor")
    public ThreadPoolTaskExecutor genericEmailTaskExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(EMAIL_QUEUE_CAPACITY);
        executor.setThreadNamePrefix("EMAIL-ASYNC-");
        executor.initialize();

        return executor;
    }
}
