package com.vorozco.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MenariniHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //Este es un metodo saludable
        return Health.up()
                .withDetail("motivo","Ya se fue la manifestacion :)")
                .build();
    }
}
