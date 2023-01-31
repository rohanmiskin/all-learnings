package org.learning.all.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.RetryListener;
import org.springframework.retry.listener.RetryListenerSupport;

import java.util.Collections;
import java.util.List;


@Configuration
@EnableRetry
@Slf4j
public class RetryConfig {

    @Bean
    public List<RetryListener> retryListeners() {

        return Collections.singletonList(new RetryListenerSupport() {

            @Override
            public <T, E extends Throwable> void onError(
                    RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                log.warn("Retryable method {} threw {}th exception {}",
                        context.getAttribute("context.name"),
                        context.getRetryCount(), throwable.toString());
            }
        });
    }
}
