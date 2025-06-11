package com.hef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hef.entity.Cricketer;
import com.hef.service.CricketerService;

@RestController
@RequestMapping("/api/cricketer")
public class CricketerController {

	@Autowired
	CricketerService service;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cricketer c) {
		String msg = service.save(c);
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveAll(@RequestBody List<Cricketer> c) {
		String msg = service.saveAll(c);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Cricketer> findById(@PathVariable int id) {
		Cricketer cricketer = service.findById(id);
		return ResponseEntity.ok(cricketer);
	}

	@GetMapping("/findall")
	public List<Cricketer> findAll() {
		List<Cricketer> cricketers = service.findAll();
		return cricketers;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Cricketer c1) {
		String msg = service.update(c1);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		String msg = service.deleteById(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/name")
	public ResponseEntity<List<Cricketer>> searchByName(@RequestParam String fullName) {
		List<Cricketer> byName = service.searchByName(fullName);
		return ResponseEntity.ok(byName);
	}

	@GetMapping("/role")
	public ResponseEntity<List<Cricketer>> getByRole(@RequestParam String role) {
		List<Cricketer> byRole = service.findByRole(role);
		return ResponseEntity.ok(byRole);
	}

	@GetMapping("/batting-style")
	public ResponseEntity<List<Cricketer>> getByBattingStyle(@RequestParam String style) {
		List<Cricketer> byBattingStyle = service.findByBattingStyle(style);
		return ResponseEntity.ok(byBattingStyle);
	}

	@GetMapping("/bowling-style")
	public ResponseEntity<List<Cricketer>> getByBowlingStyle(@RequestParam String style) {
		List<Cricketer> byBowlingStyle = service.findByBowlingStyle(style);
		return ResponseEntity.ok(byBowlingStyle);
	}

	@GetMapping("/age-range/{minAge}/{maxAge}")
	public ResponseEntity<List<Cricketer>> getByAgeRange(@PathVariable int minAge, @PathVariable int maxAge) {
		List<Cricketer> byAgeRange = service.findByAgeRange(minAge, maxAge);
		return ResponseEntity.ok(byAgeRange);
		
	}

	@GetMapping("/top-batsmen")
	public ResponseEntity<List<Cricketer>> getTopBatsmen() {
		List<Cricketer> topBatsmen = service.findTopBatsmen();
		return ResponseEntity.ok(topBatsmen);
	}

	@GetMapping("/top-bowlers")
	public ResponseEntity<List<Cricketer>> getTopBowlers() {
		List<Cricketer> topBowlers = service.findTopBowlers();
		return ResponseEntity.ok(topBowlers);
	}

	

	@GetMapping("/email")
	public ResponseEntity<Cricketer> getByEmail(@RequestParam String email) {
		Cricketer byEmail = service.findByEmail(email);
		return ResponseEntity.ok(byEmail);
	}

	@GetMapping("/recent")
	public ResponseEntity<List<Cricketer>> getRecentPlayers() {
		List<Cricketer> recentPlayers = service.findRecentPlayers();
		return ResponseEntity.ok(recentPlayers);
	}

	@GetMapping("/distinct-roles")
	public ResponseEntity<List<String>> getDistinctRoles() {
		List<String> distinctRoles = service.findDistinctRoles();
		return ResponseEntity.ok(distinctRoles);
	}

	@GetMapping("/strike-rate-above")
	public ResponseEntity<List<Cricketer>> getByStrikeRateAbove(@RequestParam double rate) {
		List<Cricketer> byStrikeRateAbove = service.findByStrikeRateAbove(rate);
		return ResponseEntity.ok(byStrikeRateAbove);
		
	}
}
