package qm.djlmx.service_broker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.Plan;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.cloudfoundry.community.servicebroker.service.CatalogService;
import org.springframework.stereotype.Service;

/**
 * <b>Attention:</b> plan and catalog do not provide right and full information
 * @author lmx
 *
 */
@Service
public class CatalogServiceImpl implements CatalogService {

	@Override
	public Catalog getCatalog() {
		return getTheCatalog();
	}

	@Override
	public ServiceDefinition getServiceDefinition(String serviceId) {
		return getTheServiceDefinition();
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

	private Catalog getTheCatalog() {
		List<ServiceDefinition> serDefList = new ArrayList<ServiceDefinition>();
		List<Plan> plans = new ArrayList<Plan>();
		plans.add(new Plan("plan_id_0001", "epser-plan", "esper plan"));
		ServiceDefinition sd = new ServiceDefinition(
				"service_id_0001", 									//id
				"esper-service",									//name
				"provide the esper service for the application",	//description
				true,												//bindable
				plans);												//plans
		serDefList.add(sd);
		Catalog catalog = new Catalog(serDefList);
		return catalog;
	}
	
}
