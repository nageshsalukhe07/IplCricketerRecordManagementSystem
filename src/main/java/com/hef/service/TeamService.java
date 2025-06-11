package com.hef.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hef.entity.Team;
import com.hef.repository.TeamRepo;

@Service
public class TeamService {

	@Autowired
	TeamRepo resp;
	
	public String save(Team t) {
		String msg = resp.save(t);
		if(Objects.isNull(msg)) {
			msg="data not inserted successfully...!";
		}
		return msg;
	}
	
	public String saveAll(List<Team> tlist) {
		String msg = resp.saveAll(tlist);
		if(Objects.isNull(msg)) {
			msg="data not inserted successfully...!";
		}
		return msg;
	}
	
	public Team findById(int id) {
		Team team = resp.findById(id);
		return team;
	}
	
	public List<Team> findAll(){
		List<Team> teams = resp.findAll();
		return teams;
	}
	
	public String update(Team t1) {
		String msg = resp.update(t1);
		if(Objects.isNull(msg)) {
			msg="record not updated successfully...!";
		}
		return msg;
	}
	
	public String deleteById(int id) {
		String msg = resp.deleteById(id);
		if(Objects.isNull(msg)) {
			msg="deletion failed..!";
		}
		return msg;
	}
	
	  public List<Team> searchByName(String keyword) {
	        return resp.searchByName(keyword);
	    }

	    public Team findByName(String name) {
	        return resp.findByName(name);
	    }

	    public List<Team> searchByCoach(String coachName) {
	        return resp.searchByCoach(coachName);
	    }

	    public List<Team> findByOwner(String ownerName) {
	        return resp.findByOwner(ownerName);
	    }

	    public List<Team> findByTitlesGreaterThan(int titles) {
	        return resp.findByTitlesGreaterThan(titles);
	    }
}
