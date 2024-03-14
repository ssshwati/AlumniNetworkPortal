package com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;     
    private String email;
    private String linkedIn;
    private String company;
    private String questions; 
    private Integer graduationYear;
    
	public Alumni() {
		super();
	}
	public Alumni(Long id, String name, int graduationYear, String email, String linkedIn, String company, String questions) {
        super();
        this.id = id;
        this.name = name;
        this.graduationYear = graduationYear;
        this.email = email;
        this.linkedIn = linkedIn;
        this.company = company;
        this.questions = questions;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public Integer getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Alumni [id=" + id + ", name=" + name + ", graduationYear=" + graduationYear + ", email=" + email
				+ ", linkedIn=" + linkedIn + ", company=" + company + ", questions=" + questions + "]";
	}
	
	
    
}
