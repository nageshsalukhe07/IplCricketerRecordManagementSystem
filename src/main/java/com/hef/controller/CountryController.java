package com.hef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hef.entity.Country;
import com.hef.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {

	@Autowired
	CountryService service;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Country t) {
		String msg = service.save(t);
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveAll(@RequestBody List<Country> clist) {
		String msg = service.saveAll(clist);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {
		
		 Country country = service.findById(id);
		 
		 if(country!=null) {
			 return ResponseEntity.ok(country);
		 }else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND) 
                     .body("Country not found with ID: " + id);
		 }
		 
	}

	@GetMapping("/findall")
	public List<Country> findAll() {
		List<Country> countries = service.findAll();
		return countries;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Country c1) {
		String msg = service.update(c1);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		String msg = service.deleteById(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/searchByName")
	public ResponseEntity<List<Country>> searchByName(@RequestParam String keyword) {
		return ResponseEntity.ok(service.searchByName(keyword));
	}

	@GetMapping("/findByCode")
	public ResponseEntity<?> findByCode(@RequestParam String code) {
		Country c = service.findByCountryCode(code);
		if (c != null)
			return ResponseEntity.ok(c);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Country with code not found: " + code);
	}

}
