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
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.President;

@RestController
@RequestMapping("/api/president")
public class PresidentController {
	private PresidentService presidentService;
	 
	   @Autowired
	   public PresidentController(PresidentService presidentService) {
		   this.presidentService=presidentService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<President>>  getAll() {
		   return  this.presidentService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody President president) {
		   return this.presidentService.add(president);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  President president) {
			return this.presidentService.delete(president);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  President  president) {
			return this.presidentService.update(president);
		}
	   
		@GetMapping("/getById")
		public DataResult<President> getById(@RequestParam int id) {
			return this.presidentService.getById(id);
     }

}
