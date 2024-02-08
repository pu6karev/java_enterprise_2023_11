package com.hillel.multi.actuator;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/*
 Create a custom Actuator endpoint with the identifier “custom”,
 activate it and add it to the health response.
 */

@Component
@Endpoint(id = "custom")
public class CustomActuatorEndpoint {

    private final DatabaseHealthIndicator databaseHealthIndicator;

    public CustomActuatorEndpoint(DatabaseHealthIndicator databaseHealthIndicator) {
        this.databaseHealthIndicator = databaseHealthIndicator;
    }

    @ReadOperation
    public CustomHealthCheck customHealth() {
        return new CustomHealthCheck(databaseHealthIndicator.health());
    }

    private static class CustomHealthCheck {
        private final Health health;

        public CustomHealthCheck(Health health) {
            this.health = health;
        }

        public String getStatus() {
            return health.getStatus().getCode();
        }

        public String getDetails() {
            return health.getDetails().toString();
        }
    }
}
