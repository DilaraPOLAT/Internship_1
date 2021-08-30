package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Agenda;


public interface AgendaService {
	DataResult<List<Agenda>>  getAll() ; 
    Result add(Agenda agenda);
    Result delete(Agenda agenda);
    Result update(Agenda agenda);
	DataResult<Agenda> getById(int id);

}
