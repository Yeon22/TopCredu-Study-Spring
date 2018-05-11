package com.example.websquare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.websquare.error.CustomErrorType;
import com.example.websquare.model.Emp;
import com.example.websquare.service.EmpServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestAPIController {
	public static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);
	
	@Autowired
	EmpServiceImpl empService;
	
	@RequestMapping(value = "/emp/", method = RequestMethod.POST)
	public ResponseEntity<List<Emp>> listAllEmps(){
		logger.info("Select All Emps");
		
		List<Emp> emps = empService.findAllEmps();
		if(emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/emp/{empno}", method = RequestMethod.POST)
	public ResponseEntity<Emp> getEmp(@PathVariable("empno") int empno) {
		logger.info("Fetching Emp with empno {}", empno);
		
		Emp emp = empService.findByEmpno(empno);
		if(emp == null) {
			logger.error("Emp with empno {} not found.", empno);
			return new ResponseEntity(new CustomErrorType("Emp with empno " + empno + " not found."), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Emp>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createEmp(@RequestBody Emp emp, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Emp : {}", emp);
		
		if(empService.isEmpExist(emp)) {
			logger.error("Unable to create. A Emp with name {} already exist.", emp.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Emp with name " + emp.getName() + " already exist."), HttpStatus.CONFLICT);
		}
		
		empService.saveEmp(emp);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/emp/{empno}").buildAndExpand(emp.getEmpno()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/emp/{empno}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmp(@PathVariable("empno") int empno, @RequestBody Emp emp) {
		logger.info("Updating Emp with empno {}", empno);
		
		Emp currentEmp = empService.findByEmpno(empno);
		if(currentEmp == null) {
			logger.error("Unable to update. Emp with empno {} not found.", empno);
			return new ResponseEntity(new CustomErrorType("Unable to update. Emp with empno " + empno + " not found."), HttpStatus.NOT_FOUND);
		}
		
		currentEmp.setName(emp.getName());
		currentEmp.setJob(emp.getJob());
		currentEmp.setSalary(emp.getSalary());
		
		empService.updateEmp(currentEmp);
		
		return new ResponseEntity<Emp>(currentEmp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/emp/{empno}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmp(@PathVariable("empno") int empno) {
		logger.info("Fetching & Deleting Emp with empno {}", empno);
		
		Emp emp = empService.findByEmpno(empno);
		if(emp == null) {
			logger.error("Unable to delete. Emp with empno {} not found.", empno);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Emp with empno " + empno + " not found."), HttpStatus.NOT_FOUND);
		}
		
		empService.deleteEmpByEmpno(empno);
		
		return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/emp/", method = RequestMethod.DELETE)
	public ResponseEntity<Emp> deleteAllEmps() {
		logger.info("Deleting All Emps");
		
		empService.deleteAllEmps();
		
		return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
	}
}
