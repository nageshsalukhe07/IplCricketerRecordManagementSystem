package com.hef.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hef.entity.User;
import com.hef.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody User u) {
		String msg = service.save(u);
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveAll(@RequestBody List<User> ulist) {
		String msg = service.saveAll(ulist);
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("/login")
	public ResponseEntity<HashMap<String, Object>> login(@RequestBody User u){
		HashMap<String, Object> user = service.login(u);
		return ResponseEntity.ok(user);
	}
}
