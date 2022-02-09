package com.spring.entity.one_to_one;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PROFILE")
public class ProfileEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="company")
	private String company;
	
	@Column(name="experience")
	private double experience;

	public ProfileEntity() {
		
	}
	
	public ProfileEntity(String company, double experience) {
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
