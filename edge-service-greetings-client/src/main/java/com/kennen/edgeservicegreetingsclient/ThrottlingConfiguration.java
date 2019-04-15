package com.kennen.edgeservicegreetingsclient;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("throttled")
@Configuration
public class ThrottlingConfiguration {

    @Bean
    RateLimiter rateLimiter(){
        return RateLimiter.create(1.0D / 10.0D);
    }
}
