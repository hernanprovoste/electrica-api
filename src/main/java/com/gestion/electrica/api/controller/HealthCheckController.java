package com.gestion.electrica.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Server is up and running!!";
    }
    

}
