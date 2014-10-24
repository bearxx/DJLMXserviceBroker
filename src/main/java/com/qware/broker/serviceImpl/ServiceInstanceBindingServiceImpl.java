package com.qware.broker.serviceImpl;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

import com.qware.broker.util.ServiceInstanceRepository;

@Service
public class ServiceInstanceBindingServiceImpl implements
		ServiceInstanceBindingService {

	/**
	 * <b>attention</b>
	 * credentials and syslogDrainUrl is made by myself.
	 */
	@Override
	public ServiceInstanceBinding createServiceInstanceBinding(
			String bindingId, ServiceInstance serviceInstance,
			String serviceId, String planId, String appGuid)
			throws ServiceInstanceBindingExistsException,
			ServiceBrokerException {
		
		return ServiceInstanceRepository.createServiceInstanceBinding(
				bindingId, serviceInstance, serviceId, planId, appGuid);
		
	}

	@Override
	public ServiceInstanceBinding getServiceInstanceBinding(String id) {
		
		return ServiceInstanceRepository.getServiceInstanceBinding(id);		
	}

	@Override
	public ServiceInstanceBinding deleteServiceInstanceBinding(
			String bindingId, ServiceInstance instance, String serviceId,
			String planId) throws ServiceBrokerException {
		
		return ServiceInstanceRepository.deleteServiceInstanceBinding(
				bindingId, instance, serviceId,
				planId);
	}

}
