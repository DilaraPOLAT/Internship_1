package com.dilarasevimpolat.Municipality.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilarasevimpolat.Municipality.business.abstracts.PresidentService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.ErrorResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.PresidentDao;
import com.dilarasevimpolat.Municipality.entities.concretes.President;

@Service
public class PresidentManager implements PresidentService{

private  PresidentDao presidentDao;

	
	@Autowired
	 public PresidentManager(PresidentDao presidentDao) {
		super();
		this.presidentDao=presidentDao;
	}
	
	@Override
	public DataResult<List<President>> getAll() {
		return new SuccessDataResult<List<President>>
		(this.presidentDao.findAll(),"President list successfully.");
	}

	@Override
	public Result add(President president) {
		 Optional<President> getPresident = presidentDao.findById(president.getPresidentId());
		   
		    if(! getPresident.isEmpty()) {
		         return new ErrorResult("There is a registered person, it cannot be added");
		    	
		    }
		       this.presidentDao.save(president);
			   return new SuccessResult("President add successfully."); 
		
		
	}

	@Override
	public Result delete(President president) {
	    this.presidentDao.deleteById(president.getPresidentId());
		return new SuccessResult("President deleted successfully.");
	}

	@Override
	public Result update(President president) {
		  Optional<President> getPresident = presidentDao.findById(president.getPresidentId());
		   
		    if(! getPresident.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.presidentDao.save(president);
			   return new SuccessResult("President update successfully."); 
	}

	@Override
	public DataResult<President> getById(int id) {
		return new SuccessDataResult<President>(this.presidentDao.getById(id));
	}	 

}
