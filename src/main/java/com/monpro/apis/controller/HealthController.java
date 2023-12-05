package com.monpro.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final Environment environment;

    @Autowired
    public HealthController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return String.format("System is running on port %s", environment.getProperty("server.port"));
    }
}
