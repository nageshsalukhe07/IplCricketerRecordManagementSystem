package com.hef.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hef.entity.Country;
import com.hef.repository.CountryRepo;

@Service
public class CountryService {

	@Autowired
	CountryRepo resp;

	public String save(Country t) {
		String msg = resp.save(t);
		if (Objects.isNull(msg)) {
			msg = "data not inserted successfully...!";
		}
		return msg;
	}

	public String saveAll(List<Country> clist) {
		String msg = resp.saveAll(clist);
		if (Objects.isNull(msg)) {
			msg = "data not inserted successfully...!";
		}
		return msg;
	}

	public Country findById(Integer id) {

		return resp.findById(id);

	}

	public List<Country> findAll() {
		List<Country> country = resp.findAll();
		return country;
	}

	public String update(Country c1) {
		String msg = resp.update(c1);
		if (Objects.isNull(msg)) {
			msg = "record not updated successfully...!";
		}
		return msg;
	}

	public String deleteById(int id) {
		String msg = resp.deleteById(id);
		if (Objects.isNull(msg)) {
			msg = "deletion failed..!";
		}
		return msg;
	}

	public List<Country> searchByName(String keyword) {
		return resp.searchByName(keyword);
	}

	public Country findByCountryCode(String code) {
		return resp.findByCountryCode(code);
	}
}
