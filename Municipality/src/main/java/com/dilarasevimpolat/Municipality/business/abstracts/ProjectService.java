package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Projects;

public interface ProjectService {
	DataResult<List<Projects>>  getAll() ; 
    Result add(Projects project);
    Result delete(Projects project);
    Result update(Projects project);
	DataResult<Projects> getById(int id);

}
