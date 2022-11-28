package com.mfu.ProjectEnterprise.model;

// import java.util.Set;

import javax.persistence.*;

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


	// @JsonIgnore
	// @OneToMany(mappedBy = "user")
	// private Set<User> booking;

	public Employee() {}

	public Employee(Long id, String surename) {
		this.id = id;
		this.surename = surename;
		
	}

	public Employee(String surename) {
		this(null, surename);
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

	

	
}