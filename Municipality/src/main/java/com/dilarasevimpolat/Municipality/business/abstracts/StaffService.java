package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Staff;

public interface StaffService {
	DataResult<List<Staff>>  getAll() ; 
    Result add(Staff staff);
    Result delete(Staff staff);
    Result update(Staff staff);
	DataResult<Staff> getById(int id);

}
