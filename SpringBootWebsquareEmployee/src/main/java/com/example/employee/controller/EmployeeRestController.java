package com.example.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.employee.error.CustomErrorType;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	public static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	EmployeeServiceImpl empService;
	
	//모든사원조회
	//Get 매핑으로 할 경우 웹스퀘어에서 못 받음
	@PostMapping("/emp.post")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		log.info("get All employees {}");
		
		List<Employee> emps = empService.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	//사번으로 사원 한명 조회
	@GetMapping("/emp/{empno}")
	public ResponseEntity<Employee> getByEmpno(@PathVariable("empno") int empno) {
		log.info("Fetching employee with empno {}", empno);
		
		Employee emp = empService.selectByEmpNo(empno);
		if(!empService.isEmployeeExist(emp)) {
			log.error("사원이 존재하지 않습니다.", empno);
			return new ResponseEntity(new CustomErrorType("해당 사번" + empno + "을 가지고 있는 사원이 존재하지 않습니다."), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	//사원 등록
	@PostMapping("/emp/")
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp, UriComponentsBuilder ucBuilder) {
		log.info("Creating Employee {}", emp);
		
		if(empService.isEmployeeExist(emp)) {
			log.error("사번 중복, 사원이 이미 존재합니다.", emp.getEname());
			return new ResponseEntity(
					new CustomErrorType("사원을 생성할수 없습니다. 해당 사원 [사번\"+emp.getEmpno()+\"] [이름:\"+emp.getEname()+\"]이 이미 존재 합니다."), HttpStatus.CONFLICT);
		}
		empService.createEmployee(emp);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/emp/{empno}").buildAndExpand(emp.getEmpno()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
	
	//사원 정보 수정
	@PutMapping("/emp/{empno}")
	public ResponseEntity<?> updateEmployee(@PathVariable("empno") int empno, @RequestBody Employee emp) {
		log.info("Updating Employee with empno {}", empno);
		
		if(!empService.isEmployeeExist(emp)) {
			log.error("사원이 존재하지 않습니다.", empno);
			return new ResponseEntity(new CustomErrorType("해당사번 " + empno + "을 가지고 있는 사원이 존재하지 않습니다."), HttpStatus.NOT_FOUND);
		}
		Employee currentEmp = emp;
		currentEmp.setSalary(emp.getSalary());
		currentEmp.setEname(emp.getEname());
		currentEmp.setJob(emp.getJob());
		currentEmp.setHiredate(emp.getHiredate());
		
		empService.updateEmployee(currentEmp);
		
		return new ResponseEntity<Employee>(currentEmp, HttpStatus.OK);
	}
	
	//사원 삭제
	@DeleteMapping("/emp/{empno}")
	public ResponseEntity<?> deleteByEmpno(@PathVariable("empno") int empno) {
		log.info("Fetching & Deleting Employee with empno {}", empno);
		
		Employee emp = empService.selectByEmpNo(empno);
		if(!empService.isEmployeeExist(emp)) {
			log.error("삭제할 수 없습니다. 사원이 존재하지 않습니다.", empno);
			return new ResponseEntity(new CustomErrorType("해당 사번"+ empno +"을 가지고 있는 사원이 존재 하지 않습니다"),HttpStatus.NOT_FOUND);
		}
		empService.deleteByEmpNo(empno);
		
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
}
