package qm.djlmx.service_broker.service.impl;

import java.util.List;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceService;

import qm.djlmx.service_broker.util.ServiceRepository;

/**
 * <b>maybe the delete function is not OK,
 * because the method does not user the rest two parameters</b>
 * maybe you need to check whether the service has no instances or the plan is not
 * used by any of the service
 * 
 * @author lmx
 *
 */
public class ServiceInstanceServiceImpl implements ServiceInstanceService {

	@Override
	public List<ServiceInstance> getAllServiceInstances() {
		return ServiceRepository.getAllServiceInstances();
	}

	@Override
	public ServiceInstance getServiceInstance(String id) {
		return ServiceRepository.getServiceInstance(id);
	}

	@Override
	public ServiceInstance createServiceInstance(ServiceDefinition service,
			String serviceInstanceId, String planId, String organizationGuid,
			String spaceGuid) throws ServiceInstanceExistsException,
			ServiceBrokerException {
		ServiceInstance serviveInstance = ServiceRepository.createServiceInstance(
				service, serviceInstanceId, planId,
				organizationGuid, spaceGuid);
		return serviveInstance;
	}

	@Override
	public ServiceInstance deleteServiceInstance(String id, String serviceId,
			String planId) throws ServiceBrokerException {
		ServiceInstance serviceInstance = ServiceRepository.deleteServiceInstance(id, serviceId, planId);
		return serviceInstance;
	}

}
