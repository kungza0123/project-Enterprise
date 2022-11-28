package com.mfu.ProjectEnterprise.controller;

import com.mfu.ProjectEnterprise.repository.*;
import com.mfu.ProjectEnterprise.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
  
  @Autowired
  private CompanyRepository companyRepo;
  
  @GetMapping("/getAllCompanys")
  public ResponseEntity<List<Company>> getAllCompanys() {
	  try {
		  List<Company> companyList = new ArrayList<>();
		  companyRepo.findAll().forEach(companyList::add);
		  
		  if(companyList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(companyList, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  @GetMapping("/getCompanyById/{id}")
  public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
	  Optional<Company> companyData = companyRepo.findById(id);
	  
	  if(companyData.isPresent()) {
		  return new ResponseEntity<>(companyData.get(), HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/addCompany")
  public ResponseEntity<Company> addCompany(@RequestBody Company company) {
	  Company usrObj = companyRepo.save(company);
	  
	  return new ResponseEntity<>(usrObj, HttpStatus.OK);
  }
  
  @PostMapping("/updateCompanyById/{id}")
  public ResponseEntity<Company> updateCompanyById(@PathVariable Long id, @RequestBody Company newCompanyData) {
	  Optional<Company> oldCompanyData = companyRepo.findById(id);
	  
	  if(oldCompanyData.isPresent()) {
		  Company updatedCompanyData = oldCompanyData.get();
		  updatedCompanyData.setNamecompany(newCompanyData.getNamecompany());
          updatedCompanyData.setEmail(newCompanyData.getEmail());
		  
		  Company usrObj = companyRepo.save(updatedCompanyData);
		  return new ResponseEntity<>(usrObj, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/deleteCompanyById/{id}")
  public ResponseEntity<HttpStatus> deleteCompanyById(@PathVariable Long id) {
	  companyRepo.deleteById(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
}