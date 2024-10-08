package com.prospecta.challange.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


/**
 * Configures RestTemplate with custom timeouts for API requests.
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(7))
                .setReadTimeout(Duration.ofSeconds(15))
                .build();
    }
}

