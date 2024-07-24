package com.example.car.service;

import com.example.car.model.Car;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    //add car
    public Car addCar(Car car) {
        return repository.save(car);
    }

    //get cars
    public List<Car> getCars() {
        return repository.findAll();
    }

    //get car by its regno
    public Car getCarById(int Id) {
        return repository.findById(Id).orElse(null);
    }

    //Adding multiple cars
    public List<Car> addCars(List<Car> cars) {
        return repository.saveAll(cars);
    }

    public Car deleted(int id) {
        Car car = repository.findById(id).orElse(null);
        if (car != null) {
            repository.delete(car);
            return car;
        }
        return null;
    }

    public Car update(Car car) {
        Car carFromDB = repository.findById(car.getId()).orElse(null);
        if (carFromDB == null) {
            return null;
        }
        carFromDB.setColour(car.getColour());
        return repository.save(carFromDB);
    }


}
