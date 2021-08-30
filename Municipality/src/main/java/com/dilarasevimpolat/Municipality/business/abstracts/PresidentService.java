package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.President;

public interface PresidentService {
	DataResult<List<President>>  getAll() ; 
    Result add(President president);
    Result delete(President president);
    Result update(President president);
	DataResult<President> getById(int id);

}
