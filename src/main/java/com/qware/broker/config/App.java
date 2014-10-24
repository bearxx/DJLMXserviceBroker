package com.qware.broker.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.qware.broker", "org.cloudfoundry.community.servicebroker"})
public class App {
    public static void main(String[] args) {
        
        SpringApplication.run(App.class, args);
    }
}
