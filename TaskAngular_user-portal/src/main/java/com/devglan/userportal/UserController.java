package com.devglan.userportal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user) throws Exception {
		System.out.println("이메일 : " + user.getEmail());
		
		//예외처리
		if(user.getEmail().equals(null)) throw new Exception();
		
		return userService.create(user);
	}
	
	@GetMapping(path = {"/{id}"})
	public User findOne(@PathVariable("id") int id) {
		return userService.findById(id);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		return userService.update(user);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public User delete(@PathVariable("id") int id) {
		return userService.delete(id);
	}
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
}
