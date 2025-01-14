package com.example.car.services;

import com.example.car.entities.Car;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CarService {

    private final WebClient.Builder webClientBuilder;

    public CarService(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder;
    }

    public List<Car> findAll(){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/client")
                .retrieve()
                .bodyToFlux(Car.class)
                .collectList()
                .block();
    }

    public Car findById(Long id){
        return webClientBuilder.build()
                .get()
                .uri("http://SERVICE-CLIENT/api/client/{id}")
                .retrieve()
                .bodyToMono(Car.class)
                .block();
    };

}
