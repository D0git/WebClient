package com.example.car.services;

import com.example.car.entities.Car;
import com.example.car.entities.Client;
import com.example.car.models.CarResponse;
import com.example.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;


    public List<Car> findAll() {
        // Retourne tous les clients
        return carRepository.findAll();
    }


}
