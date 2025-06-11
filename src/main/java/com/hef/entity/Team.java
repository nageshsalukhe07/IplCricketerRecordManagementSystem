package com.hef.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;           
    private String city;           
    private String coachName;
    private String ownerName;
    private int totalTitles;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Cricketer> cricketers;

	public Team() {
		super();
	}

	public Team(String name, String city, String coachName, String ownerName, int totalTitles,
			List<Cricketer> cricketers) {
		super();
		this.name = name;
		this.city = city;
		this.coachName = coachName;
		this.ownerName = ownerName;
		this.totalTitles = totalTitles;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getTotalTitles() {
		return totalTitles;
	}

	public void setTotalTitles(int totalTitles) {
		this.totalTitles = totalTitles;
	}

	public List<Cricketer> getCricketers() {
		return cricketers;
	}

	public void setCricketers(List<Cricketer> cricketers) {
		this.cricketers = cricketers;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", city=" + city + ", coachName=" + coachName + ", ownerName=" + ownerName + "]";
	}

    
}

