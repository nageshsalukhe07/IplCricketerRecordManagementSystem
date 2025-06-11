package com.hef.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;             
    private String countryCode;      

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<Cricketer> cricketers;

	public Country() {
		super();
	}

	public Country(String name, String countryCode, List<Cricketer> cricketers) {
		super();
		this.name = name;
		this.countryCode = countryCode;
		this.cricketers = cricketers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Cricketer> getCricketers() {
		return cricketers;
	}

	public void setCricketers(List<Cricketer> cricketers) {
		this.cricketers = cricketers;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", countryCode=" + countryCode + "]";
	}

    
}

