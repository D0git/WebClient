package com.example.car.controllers;

import com.example.car.models.CarResponse;
import com.example.car.services.CarService;
import com.example.car.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

@Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/api/car")
    public List<Car> getClients() {
        // Retourne la liste des clients
        return carService.findAll();
    }
    @GetMapping("/api/car/external")
    public String getCarsFromExternalService() {
        // Appel d'un service externe via WebClient
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
        return webClient.get()
                .uri("/api/car")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
