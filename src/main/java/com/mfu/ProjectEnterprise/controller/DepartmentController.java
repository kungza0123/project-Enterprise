// package com.mfu.ProjectEnterprise.controller;

// import com.mfu.ProjectEnterprise.repository.*;
// import com.mfu.ProjectEnterprise.model.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// @RestController
// public class DepartmentController {
  
//   @Autowired
//   private DepartmentRepository departmentRepo;
  
//   @GetMapping("/getAllDepartments")
//   public ResponseEntity<List<Department>> getAllDepartments() {
// 	  try {
// 		  List<Department> departmentList = new ArrayList<>();
// 		  departmentRepo.findAll().forEach(departmentList::add);
		  
// 		  if(departmentList.isEmpty()) {
// 			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 		  }
// 		  return new ResponseEntity<>(departmentList, HttpStatus.OK);
// 	  }catch(Exception e) {
// 		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	  }
//   }
  
//   @GetMapping("/getDepartmentById/{id}")
//   public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
// 	  Optional<Department> departmentData = departmentRepo.findById(id);
	  
// 	  if(departmentData.isPresent()) {
// 		  return new ResponseEntity<>(departmentData.get(), HttpStatus.OK);
// 	  }
// 	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//   }
  
//   @PostMapping("/addDepartment")
//   public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
// 	  Department usrObj = departmentRepo.save(department);
	  
// 	  return new ResponseEntity<>(usrObj, HttpStatus.OK);
//   }
  
//   @PostMapping("/updateDepartmentById/{id}")
//   public ResponseEntity<Department> updateDepartmentById(@PathVariable Long id, @RequestBody Department newDepartmentData) {
// 	  Optional<Department> oldDepartmentData = departmentRepo.findById(id);
	  
// 	  if(oldDepartmentData.isPresent()) {
// 		  Department updatedDepartmentData = oldDepartmentData.get();
// 		  updatedDepartmentData.setNamedepartment(newDepartmentData.getNamedepartment());
		
		  
// 		  Department usrObj = departmentRepo.save(updatedDepartmentData);
// 		  return new ResponseEntity<>(usrObj, HttpStatus.OK);
// 	  }
// 	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//   }
  
//   @DeleteMapping("/deleteDepartmentById/{id}")
//   public ResponseEntity<HttpStatus> deleteDepartmentById(@PathVariable Long id) {
// 	  departmentRepo.deleteById(id);
// 	  return new ResponseEntity<>(HttpStatus.OK);
//   }
// }