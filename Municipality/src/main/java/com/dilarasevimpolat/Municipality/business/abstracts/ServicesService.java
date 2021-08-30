package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Services;

public interface ServicesService {
	DataResult<List<Services>>  getAll() ; 
    Result add(Services services);
    Result delete(Services services);
    Result update(Services services);
	DataResult<Services> getById(int id);

}
