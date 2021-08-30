package com.dilarasevimpolat.Municipality.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilarasevimpolat.Municipality.business.abstracts.StaffService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.ErrorResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.StaffDao;
import com.dilarasevimpolat.Municipality.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService{

private  StaffDao staffDao;

	
	@Autowired
	 public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao=staffDao;
	}
	
	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>
		(this.staffDao.findAll(),"Staff list successfully.");
	}

	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Staff add successfully.");
	}

	@Override
	public Result delete(Staff staff) {
	    this.staffDao.deleteById(staff.getStaffId());
		return new SuccessResult("Stafft deleted successfully.");
	}

	@Override
	public Result update(Staff staff) {
		  Optional<Staff> getPresident = staffDao.findById(staff.getStaffId());
		   
		    if(! getPresident.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.staffDao.save(staff);
			   return new SuccessResult("Staff update successfully."); 
	}

	@Override
	public DataResult<Staff> getById(int id) {
		return new SuccessDataResult<Staff>(this.staffDao.getById(id));
	}	 

}
