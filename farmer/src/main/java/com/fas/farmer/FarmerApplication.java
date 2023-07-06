package com.fas.farmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class FarmerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
