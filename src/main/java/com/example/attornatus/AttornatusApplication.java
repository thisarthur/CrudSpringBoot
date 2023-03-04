package com.example.attornatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication(scanBasePackages = "com.example.attornatus")
@EnableJpaRepositories(basePackages = "com.example.attornatus.repository")
public class AttornatusApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttornatusApplication.class, args);
    }
}
