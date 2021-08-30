package com.dilarasevimpolat.Municipality.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilarasevimpolat.Municipality.business.abstracts.PresidentService;
import com.dilarasevimpolat.Municipality.business.abstracts.ProjectService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.President;
import com.dilarasevimpolat.Municipality.entities.concretes.Projects;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	private ProjectService projectService;
	 
	   @Autowired
	   public ProjectController(ProjectService projectService) {
		   this.projectService=projectService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Projects>>  getAll() {
		   return  this.projectService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Projects project) {
		   return this.projectService.add(project);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Projects project) {
			return this.projectService.delete(project);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Projects  project) {
			return this.projectService.update(project);
		}
	   
		@GetMapping("/getById")
		public DataResult<Projects> getById(@RequestParam int id) {
			return this.projectService.getById(id);
  }

}
