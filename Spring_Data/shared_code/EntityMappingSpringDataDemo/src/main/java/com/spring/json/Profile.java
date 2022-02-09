package com.spring.json;

public class Profile {

	private Long id;
	
	private String company;
	
	private double experience;

	public Profile() {
		
	}
	
	public Profile(String company, double experience) {
		this.company = company;
		this.experience = experience;
	}

	public Profile(Long id, String company, double experience) {
		this.id = id;
		this.company = company;
		this.experience = experience;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String toString() {
		return id + " - " + experience + " - " + company;
	}
	
}
