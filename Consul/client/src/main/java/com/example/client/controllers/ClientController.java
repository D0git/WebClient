package com.example.client.controllers;

import com.example.client.entities.Client;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/api/client")
    public List<Client> getClients() {
        // Retourne la liste des clients
        return clientService.findAll();
    }

    @GetMapping("/api/client/external")
    public String getClientsFromExternalService() {
        // Appel d'un service externe via WebClient
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
        return webClient.get()
                .uri("/api/client")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
