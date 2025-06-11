package com.hef.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hef.entity.User;
import com.hef.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	
	public String save(User u) {
		String msg = repo.save(u);
		if(Objects.isNull(msg)) {
			msg="record not inserted";
		}
		return msg;
		
	}
	
	public String saveAll(List<User> ulist) {
		String msg = repo.saveAll(ulist);
		if(Objects.isNull(msg)) {
			msg="record not inserted";
		}
		return msg;
		
	}
	
	public HashMap<String, Object> login(User u) {
		
		User user = repo.login(u);
		
		HashMap<String,Object> map = new HashMap<>();
		
		if(user!=null) {
			map.put("msg","vaild user");
			map.put("user", user);
		}else {
			map.put("msg", "invalid user");
			map.put("user", null);
		}
		return map;
	}
	
}
