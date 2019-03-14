package org.dropwizard.rest;

import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.dropwizard.rest.health.DemoHealthCheck;
import org.dropwizard.rest.resources.DemoResource;

public class WizardRestApplication extends Application<WizardRestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WizardRestApplication().run(new String[]{"server", "org/dropwizard/rest/config.yml"});
    }

    @Override
    public String getName() {
        return "WizardRest";
    }

    @Override
    public void initialize(final Bootstrap<WizardRestConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new ResourceConfigurationSourceProvider());
    }

    @Override
    public void run(final WizardRestConfiguration configuration,
                    final Environment environment) {
        registerDemoResource(configuration, environment);
        registerHealthCheck(environment);
    }

    private void registerHealthCheck(Environment environment) {
        environment.healthChecks().register("Dropwizard", new DemoHealthCheck());
    }

    private void registerDemoResource(WizardRestConfiguration configuration, Environment environment) {
        environment.jersey().register(new DemoResource(configuration.getMessage(),
                configuration.getFirstParameter(), configuration.getSecondParameter()));
    }

}
