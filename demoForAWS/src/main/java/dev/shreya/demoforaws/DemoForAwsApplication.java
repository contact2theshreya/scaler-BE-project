package dev.shreya.demoforaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching//i want to cache things
@EnableScheduling
public class DemoForAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoForAwsApplication.class, args);
    }

}
