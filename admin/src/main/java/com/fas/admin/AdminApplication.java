package com.fas.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application file to run Spring Boot app
 *
 * @author Prateek singh
 */

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
