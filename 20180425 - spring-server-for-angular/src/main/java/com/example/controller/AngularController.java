package com.example.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;

@RestController
public class AngularController {
	private List<Employee> employees = new ArrayList<Employee>();

	public AngularController() {
		employees.add(new Employee(1, "ADAM", "Sandler"));
		employees.add(new Employee(2, "BOB", "Ross"));
		employees.add(new Employee(3, "CHRIS", "Evans"));
	}

	@GetMapping("/employees")
	public Object get() {
		return employees;
	}

	@PostMapping("/employees")
	public Object post(@RequestBody Employee employee) {
		if (employees.size() > 0) {
			Comparator<Employee> comp = (e1, e2) -> Integer.compare(e1.getId(), e2.getId());
			Employee emp = employees.stream().max(comp).get();
			employee.setId(emp.getId() + 1);
		} else {
			employee.setId(1);
		}
		employees.add(employee);
		return employee;
	}

	@DeleteMapping("/employees/{id}")
	public Object delete(@PathVariable int id) {
		Employee emp = employees.stream().filter((e) -> e.getId() == id).findAny().orElse(null);
		if (emp != null) {
			employees.remove(emp);
		}
		return employees;
	}
}
