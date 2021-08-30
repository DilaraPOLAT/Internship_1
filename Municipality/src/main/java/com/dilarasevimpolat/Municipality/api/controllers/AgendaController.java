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

import com.dilarasevimpolat.Municipality.business.abstracts.AgendaService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Agenda;


@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

	private AgendaService agendaService;
	 
	   @Autowired
	   public AgendaController(AgendaService agendaService) {
		   this.agendaService=agendaService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Agenda>>  getAll() {
		   return  this.agendaService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Agenda agenda) {
		   return this.agendaService.add(agenda);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Agenda agenda) {
			return this.agendaService.delete(agenda);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Agenda  agenda) {
			return this.agendaService.update(agenda);
		}
	   
		@GetMapping("/getById")
		public DataResult<Agenda> getById(@RequestParam int id) {
			return this.agendaService.getById(id);
        }
}