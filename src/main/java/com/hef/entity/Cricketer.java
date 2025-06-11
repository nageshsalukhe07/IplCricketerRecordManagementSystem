package com.hef.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cricketers")
public class Cricketer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String role;
    private String battingStyle;
    private String bowlingStyle;

    private int age;
    private int matchesPlayed;
    private int runsScored;
    private int wicketsTaken;
    private double battingAverage;
    private double bowlingAverage;
    private double strikeRate;
    private double salary;

    private String contactNumber;

    @Column(unique = true)
    private String emailId;

    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


	public Cricketer() {
		super();
	}

	public Cricketer(String fullName, String role, String battingStyle, String bowlingStyle, int age, int matchesPlayed,
			int runsScored, int wicketsTaken, double battingAverage, double bowlingAverage, double strikeRate,
			double salary, String contactNumber, String emailId, String createdBy, Date createdDate, String updatedBy,
			Date updatedDate, Team team, Country country, User user) {
		super();
		this.fullName = fullName;
		this.role = role;
		this.battingStyle = battingStyle;
		this.bowlingStyle = bowlingStyle;
		this.age = age;
		this.matchesPlayed = matchesPlayed;
		this.runsScored = runsScored;
		this.wicketsTaken = wicketsTaken;
		this.battingAverage = battingAverage;
		this.bowlingAverage = bowlingAverage;
		this.strikeRate = strikeRate;
		this.salary = salary;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.team = team;
		this.country = country;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBattingStyle() {
		return battingStyle;
	}

	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}

	public String getBowlingStyle() {
		return bowlingStyle;
	}

	public void setBowlingStyle(String bowlingStyle) {
		this.bowlingStyle = bowlingStyle;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	public double getBowlingAverage() {
		return bowlingAverage;
	}

	public void setBowlingAverage(double bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cricketer [fullName=" + fullName + ", role=" + role + ", age=" + age + ", salary=" + salary
				+ ", contactNumber=" + contactNumber + ", emailId=" + emailId + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", team=" + team + ", country=" + country + ", user=" + user + "]";
	}

    
}
