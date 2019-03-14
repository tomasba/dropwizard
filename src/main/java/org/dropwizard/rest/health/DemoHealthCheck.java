package org.dropwizard.rest.health;

import com.codahale.metrics.health.HealthCheck;

public class DemoHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        final String field = "Dropwizard";
        if (field.equalsIgnoreCase("Dropwizard")) {
            return Result.healthy();
        }
        return Result.unhealthy("Error, not Healthy!");
    }
}