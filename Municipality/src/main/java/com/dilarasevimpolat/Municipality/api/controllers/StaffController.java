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

import com.dilarasevimpolat.Municipality.business.abstracts.StaffService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	private StaffService staffService;
	 
	   @Autowired
	   public StaffController(StaffService staffService) {
		   this.staffService=staffService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Staff>>  getAll() {
		   return  this.staffService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Staff staff) {
		   return this.staffService.add(staff);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Staff staff) {
			return this.staffService.delete(staff);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Staff  staff) {
			return this.staffService.update(staff);
		}
	   
		@GetMapping("/getById")
		public DataResult<Staff> getById(@RequestParam int id) {
			return this.staffService.getById(id);
}

}
