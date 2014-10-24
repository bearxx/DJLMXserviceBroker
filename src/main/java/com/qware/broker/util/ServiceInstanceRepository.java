package com.qware.broker.util;

import java.util.HashMap;
import java.util.Map;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;

public class ServiceInstanceRepository {
	private static Map<String, ServiceInstanceBinding> bindingRepo
								= new HashMap<String, ServiceInstanceBinding>();
	
	public static ServiceInstanceBinding createServiceInstanceBinding(
			String bindingId, ServiceInstance serviceInstance,
			String serviceId, String planId, String appGuid)
					throws ServiceInstanceBindingExistsException {
		if(bindingRepo.containsKey(bindingId)) {
			ServiceInstanceBinding sib = bindingRepo.get(bindingId);
			throw new ServiceInstanceBindingExistsException(sib);
		}
		Map<String, Object> credentials = new HashMap<String, Object>();
		credentials.put("username", "djlmx");
		credentials.put("password", 123456);
		String syslogDrainUrl = null;
		ServiceInstanceBinding sib = new ServiceInstanceBinding(bindingId,
				serviceInstance.getId(), credentials, syslogDrainUrl, appGuid);
		bindingRepo.put(bindingId, sib);
		return sib;
	}

	public static ServiceInstanceBinding getServiceInstanceBinding(String id) {
		return bindingRepo.get(id);
	}

	public static ServiceInstanceBinding deleteServiceInstanceBinding(
			String bindingId, ServiceInstance instance, String serviceId,
			String planId) throws ServiceBrokerException {
		if(bindingRepo.get(bindingId) == null) {
			throw new ServiceBrokerException("The Service Instance does not exit!");
		}
		ServiceInstanceBinding sib = bindingRepo.get(bindingId);
		bindingRepo.remove(bindingId);
		return sib;
	}

}
