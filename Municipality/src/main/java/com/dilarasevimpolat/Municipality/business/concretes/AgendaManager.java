package com.dilarasevimpolat.Municipality.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilarasevimpolat.Municipality.business.abstracts.AgendaService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.ErrorResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.AgendaDao;
import com.dilarasevimpolat.Municipality.entities.concretes.Agenda;
 
@Service
public class AgendaManager implements AgendaService{

private AgendaDao agendaDao;

	
	@Autowired
	 public AgendaManager(AgendaDao agendaDao) {
		super();
		this.agendaDao=agendaDao;
	}
	
	@Override
	public DataResult<List<Agenda>> getAll() {
		return new SuccessDataResult<List<Agenda>>
		(this.agendaDao.findAll(),"Agenda list successfully.");
	}

	@Override
	public Result add(Agenda agenda) {
		this.agendaDao.save(agenda);
		return new SuccessResult("Agenda add successfully.");
	}

	@Override
	public Result delete(Agenda agenda) {
	    this.agendaDao.deleteById(agenda.getAgendaId());
		return new SuccessResult("Agenda deleted successfully.");
	}

	@Override
	public Result update(Agenda agenda) {
		  Optional<Agenda> getAgenda = agendaDao.findById(agenda.getAgendaId());
		   
		    if(! getAgenda.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.agendaDao.save(agenda);
			   return new SuccessResult("Agenda update successfully."); 
	}

	@Override
	public DataResult<Agenda> getById(int id) {
		return new SuccessDataResult<Agenda>(this.agendaDao.getById(id));
	}		    

}
