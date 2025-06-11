package com.hef.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	private String last_name;
	private String gender;
	
	@Column(unique = true)
	private String emailid;
	private String mobileno;
	private String address;
	private String password;
	private String role;
	public User() {
		super();
	}
	public User(String first_name, String last_name, String gender, String emailid, String mobileno, String address,
			String password, String role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", gender=" + gender + ", emailid=" + emailid + ", mobileno="
				+ mobileno + ", password=" + password + ", role=" + role + "]";
	}
	
	
    
}

