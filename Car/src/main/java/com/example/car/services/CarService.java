package com.example.car.services;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(Long id) throws Exception{
        return carRepository.findById(id).orElseThrow(() -> new
                Exception("Invalid Car ID"));
    }
}
