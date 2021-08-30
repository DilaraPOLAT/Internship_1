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

import com.dilarasevimpolat.Municipality.business.abstracts.ServicesService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Services;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
	private ServicesService servicesService;
	 
	   @Autowired
	   public ServiceController(ServicesService servicesService) {
		   this.servicesService=servicesService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Services>>  getAll() {
		   return  this.servicesService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Services services) {
		   return this.servicesService.add(services);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Services services) {
			return this.servicesService.delete(services);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Services  services) {
			return this.servicesService.update(services);
		}
	   
		@GetMapping("/getById")
		public DataResult<Services> getById(@RequestParam int id) {
			return this.servicesService.getById(id);
}

}
