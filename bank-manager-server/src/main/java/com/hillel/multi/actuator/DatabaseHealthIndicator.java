package com.hillel.multi.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;


// --- Create a custom health check endpoint to test my database connection.
@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    private final DataSource dataSource;

    public DatabaseHealthIndicator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health health() {
        try {
            Connection connection = dataSource.getConnection();
            if (connection != null) {
                connection.close();
                return Health.up().withDetail("database", "cool connection").build();
            } else {
                return Health.down().withDetail("database", "connection failed").build();
            }
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}