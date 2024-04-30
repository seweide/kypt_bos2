package net.liangyihui.manager.kypt.bos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author liu_y
 */
@Configuration
@Profile({"local", "dev"})
public class AppConfigDev {


    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new LoggingClientHttpRequestInterceptor()));
        return restTemplate;
    }


}
