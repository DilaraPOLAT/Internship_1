package com.dilarasevimpolat.Municipality.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilarasevimpolat.Municipality.business.abstracts.ProjectService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.ErrorResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.ProjectDao;
import com.dilarasevimpolat.Municipality.entities.concretes.Projects;

@Service
public class ProjectManager implements ProjectService{

private  ProjectDao projectDao;

	
	@Autowired
	 public ProjectManager(ProjectDao projectDao) {
		super();
		this.projectDao=projectDao;
	}
	
	@Override
	public DataResult<List<Projects>> getAll() {
		return new SuccessDataResult<List<Projects>>
		(this.projectDao.findAll(),"Project list successfully.");
	}

	@Override
	public Result add(Projects project) {
		this.projectDao.save(project);
		return new SuccessResult("Project add successfully.");
	}

	@Override
	public Result delete(Projects project) {
	    this.projectDao.deleteById(project.getProjectId());
		return new SuccessResult("Project deleted successfully.");
	}

	@Override
	public Result update(Projects project) {
		  Optional<Projects> getProject = projectDao.findById(project.getProjectId());
		   
		    if(! getProject.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.projectDao.save(project);
			   return new SuccessResult("Project update successfully."); 
	}

	@Override
	public DataResult<Projects> getById(int id) {
		return new SuccessDataResult<Projects>(this.projectDao.getById(id));
	}	 


}
