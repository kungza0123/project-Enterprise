package com.mfu.ProjectEnterprise.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="EMPLOYEE_ID")
	private Long id;

	@Column(name="SURENAME")
	private String surename;
	@Column(name="EMAIL")
	private String email;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne
    @JoinColumn(name = "DEPARTMENTS_ID")
    private Department department;


	public Employee() {}

	public Employee(Long id, String surename,String email) {
		this.id = id;
		this.surename = surename;
		this.email = email;
		
	}

	public Employee(String surename,String email) {
		this(null, surename,email);
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
}