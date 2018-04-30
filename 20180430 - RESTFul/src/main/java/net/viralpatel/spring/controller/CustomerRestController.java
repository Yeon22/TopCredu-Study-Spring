package net.viralpatel.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.viralpatel.spring.dao.CustomerDAO;
import net.viralpatel.spring.model.Customer;

@RestController

public class CustomerRestController {
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Customer>> getCustomers() {
		System.out.println("µø¿€");
		HttpHeaders headers = new HttpHeaders();
		List<Customer> customers = customerDAO.list();

		if (customers == null) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}

		//headers.add("Content-Type", "application/json");
		headers.add("Number Of Records Found", String.valueOf(customers.size()));
		
		return new ResponseEntity<List<Customer>>(customers, headers, HttpStatus.OK);
	}

//	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
//		Customer customer = customerDAO.get(id);
//		if (customer == null) {
//			return new ResponseEntity("No Customer found for Id " + id, HttpStatus.NOT_FOUND);
//		}

//		return new ResponseEntity(customer, HttpStatus.OK);
//	}

//	@PostMapping(value = "/customers")
//	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//		customerDAO.create(customer);
//		return new ResponseEntity(customer, HttpStatus.OK);
//	}

//	@DeleteMapping("/customers/{id}")
//	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
//		if (null == customerDAO.delete(id)) {
//			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//		}

//		return new ResponseEntity(id, HttpStatus.OK);
//	}

//	@PutMapping("/customers/{id}")
//	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
//		customer = customerDAO.update(id, customer);
//		if (null == customer) {
//			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//		}

//		return new ResponseEntity(customer, HttpStatus.OK);
//	}

}
