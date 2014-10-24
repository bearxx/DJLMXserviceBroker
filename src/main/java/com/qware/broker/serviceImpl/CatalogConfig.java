package com.qware.broker.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.Plan;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {
    
    @Bean
    public Catalog catalog() {
        ArrayList<ServiceDefinition> services = new ArrayList<ServiceDefinition>();
        services.add(getTheServiceDefinition());
        
        return new Catalog(services);
        
    }
    
    private ServiceDefinition getTheServiceDefinition() {
		List<Plan> plans = new ArrayList<Plan>();
		plans.add(new Plan("plan_id_0001", "epser-plan", "esper plan"));
		ServiceDefinition sd = new ServiceDefinition(
				"service_id_0001", 									//id
				"esper-service",									//name
				"provide the esper service for the application",	//description
				true,												//bindable
				plans);		
		return sd;
	}
    
}
