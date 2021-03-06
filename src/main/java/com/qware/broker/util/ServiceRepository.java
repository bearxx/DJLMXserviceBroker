package com.qware.broker.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.springframework.stereotype.Service;

/**
 * This is the repository which store the informations of the broker Now you
 * should know that it is just a tool toi manage the service
 * 
 * @author lmx
 * 
 */
@Service
public class ServiceRepository {

	private static Map<String, ServiceInstance> repo = new HashMap<String, ServiceInstance>();

	public static List<ServiceInstance> getAllServiceInstances() {
//		ServiceInstance instTest = new ServiceInstance("1", "2", "3", "4", "5", null);
		List<ServiceInstance> list = new ArrayList<ServiceInstance>();
		for(Entry<String, ServiceInstance> entry : repo.entrySet()) {
			list.add( entry.getValue());
		}
		return list;
//		return (List<ServiceInstance>) repo.values();
	}

	public static ServiceInstance getServiceInstance(String id) {
		return repo.get(id);
	}

	public static ServiceInstance createServiceInstance(ServiceDefinition service,
			String serviceInstanceId, String planId, String organizationGuid,
			String spaceGuid) throws ServiceInstanceExistsException {
		if(repo.containsKey(serviceInstanceId)) {
			ServiceInstance instance = repo.get(serviceInstanceId);
			throw new ServiceInstanceExistsException(instance);
		}
		ServiceInstance serviveInstance = new ServiceInstance(serviceInstanceId,
				service.getId(), planId, organizationGuid, spaceGuid,null);
		repo.put(serviceInstanceId, serviveInstance);
		return serviveInstance;
	}

	public static ServiceInstance deleteServiceInstance(String id,
			String serviceId, String planId) throws ServiceBrokerException {
		if(repo.containsKey(id)) {
			throw new ServiceBrokerException("The service instance does not exist");
		}
		ServiceInstance serviceInstance = repo.get(id);
		repo.remove(id);
		return serviceInstance;
	}

}
