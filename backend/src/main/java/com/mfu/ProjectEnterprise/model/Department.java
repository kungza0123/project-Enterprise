package com.mfu.ProjectEnterprise.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="DEPARTMENTS_ID")
	private Long id;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Column(name="NAMEDEPARTMENT")
	private String namedepartment;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne
    @JoinColumn(name = "COMPANYS_ID")
    private Company company;

	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;

	public Department() {}

	public Department(Long id, String namedepartment) {
		this.id = id;
		this.namedepartment = namedepartment;
		
	}

	public Department(String namedepartment) {
		this(null, namedepartment);
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamedepartment() {
        return namedepartment;
    }

    public void setNamedepartment(String namedepartment) {
        this.namedepartment = namedepartment;
    }

	

	
}