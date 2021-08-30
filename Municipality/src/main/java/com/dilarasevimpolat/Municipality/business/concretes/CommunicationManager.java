package com.dilarasevimpolat.Municipality.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilarasevimpolat.Municipality.business.abstracts.CommunicationService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.ErrorResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.CommunicationDao;
import com.dilarasevimpolat.Municipality.entities.concretes.Communication;

@Service
public class CommunicationManager implements CommunicationService{

private CommunicationDao communicationDao;

	
	@Autowired
	 public CommunicationManager(CommunicationDao communicationDao) {
		super();
		this.communicationDao=communicationDao;
	}
	
	@Override
	public DataResult<List<Communication>> getAll() {
		return new SuccessDataResult<List<Communication>>
		(this.communicationDao.findAll(),"Communication list successfully.");
	}

	@Override
	public Result add(Communication communication) {
		this.communicationDao.save(communication);
		return new SuccessResult("Communication add successfully.");
	}

	@Override
	public Result delete(Communication communication) {
	    this.communicationDao.deleteById(communication.getCommunicationId());
		return new SuccessResult("Communication deleted successfully.");
	}

	@Override
	public Result update(Communication communication) {
		  Optional<Communication> getCommunication = communicationDao.findById(communication.getCommunicationId());
		   
		    if(! getCommunication.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.communicationDao.save(communication);
			   return new SuccessResult("Communication update successfully."); 
	}

	@Override
	public DataResult<Communication> getById(int id) {
		return new SuccessDataResult<Communication>(this.communicationDao.getById(id));
	}	 

}
