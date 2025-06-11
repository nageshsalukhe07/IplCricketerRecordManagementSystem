package com.hef.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hef.entity.Cricketer;
import com.hef.repository.CricketerRepo;

@Service
public class CricketerService {

	@Autowired
	CricketerRepo resp;
	
	public String save(Cricketer c) {
		String msg = resp.save(c);
		if(Objects.isNull(msg)) {
			msg="data not inserted successfully...!";
		}
		return msg;
	}
	
	public String saveAll(List<Cricketer> clist) {
		String msg = resp.saveAll(clist);
		if(Objects.isNull(msg)) {
			msg="data not inserted successfully...!";
		}
		return msg;
	}
	
	public Cricketer findById(int id) {
		Cricketer cricketer = resp.findById(id);
		return cricketer;
	}
	
	public List<Cricketer> findAll(){
		List<Cricketer> cricketers = resp.findAll();
		return cricketers;
	}
	
	public String update(Cricketer c1) {
		String msg = resp.update(c1);
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
	

    public List<Cricketer> searchByName(String fullName) {
        return resp.searchByName(fullName);
    }

    public List<Cricketer> findByRole(String role) {
        return resp.findByRole(role);
    }

    public List<Cricketer> findByBattingStyle(String style) {
        return resp.findByBattingStyle(style);
    }

    public List<Cricketer> findByBowlingStyle(String style) {
        return resp.findByBowlingStyle(style);
    }

    public List<Cricketer> findByAgeRange(int minAge, int maxAge) {
        return resp.findByAgeRange(minAge, maxAge);
    }

    public List<Cricketer> findTopBatsmen() {
        return resp.findTopBatsmen();
    }

    public List<Cricketer> findTopBowlers() {
        return resp.findTopBowlers();
    }

   

    public Cricketer findByEmail(String emailId) {
        return resp.findByEmail(emailId);
    }

    public List<Cricketer> findRecentPlayers() {
        return resp.findRecentPlayers();
    }

    public List<String> findDistinctRoles() {
        return resp.findDistinctRoles();
    }

    public List<Cricketer> findByStrikeRateAbove(double rate) {
        return resp.findByStrikeRateAbove(rate);
    }
}
