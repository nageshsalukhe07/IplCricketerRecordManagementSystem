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

import com.hef.entity.Team;
import com.hef.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {

	@Autowired
	TeamService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Team t) {
		String msg = service.save(t);
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveAll(@RequestBody List<Team> tlist) {
		String msg = service.saveAll(tlist);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Team> findById(@PathVariable int id) {
		Team team = service.findById(id);
		return ResponseEntity.ok(team);
	}
	
	@GetMapping("/findall")
	public List<Team> findAll(){
		List<Team> teams = service.findAll();
		return teams;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Team t1) {
		String msg = service.update(t1);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		String msg = service.deleteById(id);
		return ResponseEntity.ok(msg);
	}
	
    @GetMapping("/searchbyname")
    public ResponseEntity<List<Team>> searchByName(@RequestParam String keyword) {
        List<Team> searchByName = service.searchByName(keyword);
        return ResponseEntity.ok(searchByName);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        Team team = service.findByName(name);
        if (team != null) {
            return ResponseEntity.ok(team); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Team not found with name: " + name); 
        }
    }

    @GetMapping("/searchByCoach")
    public ResponseEntity<List<Team>> searchByCoach(@RequestParam String coachName) {
         List<Team> searchByCoach = service.searchByCoach(coachName);
         return ResponseEntity.ok(searchByCoach);
    }

    @GetMapping("/searchByOwner")
    public ResponseEntity<List<Team>> findByOwner(@RequestParam String ownerName) {
         List<Team> byOwner = service.findByOwner(ownerName);
         return ResponseEntity.ok(byOwner);
    }

    @GetMapping("/findByTitlesGreaterThan")
    public ResponseEntity<List<Team>> findByTitlesGreaterThan(@RequestParam int titles) {
         List<Team> byTitlesGreaterThan = service.findByTitlesGreaterThan(titles);
         return ResponseEntity.ok(byTitlesGreaterThan);
    }
	
}
