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

import com.dilarasevimpolat.Municipality.business.abstracts.CommunicationService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Communication;


@RestController
@RequestMapping("/api/communication")
public class CommunicationController {
	private CommunicationService  communicationService ;
	 
	   @Autowired
	   public CommunicationController(CommunicationService communicationService ) {
		   this.communicationService =communicationService ;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Communication>>  getAll() {
		   return  this.communicationService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Communication communication) {
		   return this.communicationService.add(communication);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Communication communication) {
			return this.communicationService.delete(communication);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Communication  communication) {
			return this.communicationService.update(communication);
		}
	   
		@GetMapping("/getById")
		public DataResult<Communication> getById(@RequestParam int id) {
			return this.communicationService.getById(id);
     }

}
