package com.mfu.ProjectEnterprise.controller;

import com.mfu.ProjectEnterprise.model.*;
import com.mfu.ProjectEnterprise.repository.*;
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
public class EmployeeController {
  
  @Autowired
  private EmployeeRepository employeeRepo;
  
  @GetMapping("/getAllEmployees")
  public ResponseEntity<List<Employee>> getAllEmployees() {
	  try {
		  List<Employee> employeeList = new ArrayList<>();
		  employeeRepo.findAll().forEach(employeeList::add);
		  
		  if(employeeList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(employeeList, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  @GetMapping("/getEmployeeById/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	  Optional<Employee> employeeData = employeeRepo.findById(id);
	  
	  if(employeeData.isPresent()) {
		  return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/addEmployee")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	  Employee usrObj = employeeRepo.save(employee);
	  
	  return new ResponseEntity<>(usrObj, HttpStatus.OK);
  }
  
  @PostMapping("/updateEmployeeById/{id}")
  public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee newEmployeeData) {
	  Optional<Employee> oldEmployeeData = employeeRepo.findById(id);
	  
	  if(oldEmployeeData.isPresent()) {
		  Employee updatedEmployeeData = oldEmployeeData.get();
		  
		  updatedEmployeeData.setSurename(newEmployeeData.getSurename());
		  updatedEmployeeData.setEmail(newEmployeeData.getEmail());
		  
		  Employee usrObj = employeeRepo.save(updatedEmployeeData);
		  return new ResponseEntity<>(usrObj, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/deleteEmployeeById/{id}")
  public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
	  employeeRepo.deleteById(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
}