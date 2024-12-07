package dev.shreya.demoforaws.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
    private CarService carService;

    public ScheduleTasks(CarService carService) {
        this.carService = carService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void execute(){
        carService.deleteAll();
    }
}
