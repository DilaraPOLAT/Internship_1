package com.dilarasevimpolat.Municipality.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dilarasevimpolat.Municipality.business.abstracts.PresidentImageService;
import com.dilarasevimpolat.Municipality.entities.concretes.President;
import com.dilarasevimpolat.Municipality.entities.concretes.PresidentImage;

@RestController
@RequestMapping("/api/presidentImage")
public class PresidentImageController {

	private PresidentImageService presidentImageService;

	@Autowired
	public PresidentImageController(PresidentImageService presidentImageService) {
		super();
		this.presidentImageService = presidentImageService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int presidentID) {
		PresidentImage presidentImage = new PresidentImage();
		President president = new President();
		president.setPresidentId(presidentID);
		presidentImage.setPresident(president);
		return ResponseEntity.ok(this.presidentImageService.add(presidentImage, file));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.presidentImageService.getAll());
	}
	
	@GetMapping("/getOne")
	public ResponseEntity<?> getOne(int homeInformationId) {
		return ResponseEntity.ok(this.presidentImageService.getAllByPresidentId(homeInformationId));
	}

}
