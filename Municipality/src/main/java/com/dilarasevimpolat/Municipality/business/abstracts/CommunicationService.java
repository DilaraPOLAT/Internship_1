package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Communication;



public interface CommunicationService {
	DataResult<List<Communication>>  getAll() ; 
    Result add(Communication communication);
    Result delete(Communication communication);
    Result update(Communication communication);
	DataResult<Communication> getById(int id);

}
