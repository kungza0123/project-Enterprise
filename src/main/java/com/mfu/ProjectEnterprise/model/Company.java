package com.mfu.ProjectEnterprise.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COMPANYS")
public class Company{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="COMPANYS_ID")
	private Long id;

	@Column(name="NAMECOMPANY")
	private String namecompany;
    @Column(name="EMAIL")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private Set<Department> departments;

	public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Company() {}

	public Company(Long id, String namecompany,String email) {
		this.id = id;
		this.namecompany = namecompany;
        this.email = email;
		
	}

	public Company(String namecompany,String email) {
		this(null, namecompany,email);
	}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namedepartment) {
        this.namecompany = namedepartment;
    }

	

	
}