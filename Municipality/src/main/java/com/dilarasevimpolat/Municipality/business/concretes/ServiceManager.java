package com.dilarasevimpolat.Municipality.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilarasevimpolat.Municipality.business.abstracts.ServicesService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.ErrorResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.ServiceDao;
import com.dilarasevimpolat.Municipality.entities.concretes.Services;

@Service
public class ServiceManager implements ServicesService{


private  ServiceDao serviceDao;

	
	@Autowired
	 public ServiceManager(ServiceDao serviceDao) {
		super();
		this.serviceDao=serviceDao;
	}
	
	@Override
	public DataResult<List<Services>> getAll() {
		return new SuccessDataResult<List<Services>>
		(this.serviceDao.findAll(),"Service list successfully.");
	}

	@Override
	public Result add(Services services) {
		this.serviceDao.save(services);
		return new SuccessResult("Service add successfully.");
	}

	@Override
	public Result delete(Services services) {
	    this.serviceDao.deleteById(services.getServiceId());
		return new SuccessResult("Service deleted successfully.");
	}

	@Override
	public Result update(Services service) {
		  Optional<Services> getServices = serviceDao.findById(service.getServiceId());
		   
		    if(! getServices.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.serviceDao.save(service);
			   return new SuccessResult("Services update successfully."); 
	}

	@Override
	public DataResult<Services> getById(int id) {
		return new SuccessDataResult<Services>(this.serviceDao.getById(id));
	}	  

}
