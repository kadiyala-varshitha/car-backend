package com.example.car.controllers;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    @PostMapping("/cars2")
    public ResponseEntity<List<Car>> createCars(@RequestBody List<Car> cars) {
        return new ResponseEntity<>(carService.addCars(cars), HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity deleted(@PathVariable int id) {
        Car car = carService.deleted(id);
        if (car != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/cars")
    public ResponseEntity<Car> update(@RequestBody Car car) {
        Car carFromService = carService.update(car);
        if (carFromService == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carFromService, HttpStatus.OK);
    }

}
