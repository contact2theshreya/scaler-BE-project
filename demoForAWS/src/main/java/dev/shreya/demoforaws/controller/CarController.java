package dev.shreya.demoforaws.controller;

import dev.shreya.demoforaws.model.Car;
import dev.shreya.demoforaws.service.CarService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @Cacheable(value = "car")
    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable("id") int id){
        return carService.getCar(id);
    }

    @Cacheable(value = "car")
    @GetMapping("/car")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @CachePut(value = "car", key = "#car.id", unless = "#car.brand == null")
    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
    @CachePut(value = "car", key = "#car.id", unless = "#car.brand == null")
    //save in vavhe with key id and untill brand is not null
    //# car-object
    //cars - name of hashmap
    @PutMapping("/car/{id}")
    public Car updateCar(@PathVariable("id") int carId, @RequestBody Car car){
        //call service and update details for the given id
        return null;
    }

    @CacheEvict(value = "car", key = "#car.id")
    @DeleteMapping("/car/{id}")
    public Car deleteCar(@PathVariable("id") int carId) {
        Car c = carService.getCar(carId);
        carService.deleteCar(carId);
        return c;
    }
}
