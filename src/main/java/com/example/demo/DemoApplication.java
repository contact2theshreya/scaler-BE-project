package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
//The Spring Boot CLI (Command Line Interface) is present in the dependency of the org.springframework.boot that is used to quickly bootstrap the spring boot application. CLI in Spring Boot contains a run method() that is executed after the application startup.

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LoggingService loggingService = new LoggingService();
        loggingService.doSomething();
    }
}
