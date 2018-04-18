package com.devglan.userportal;

import java.util.List;
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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping(path = {"/{id}"})
	@ExceptionHandler(UserNotFoundException.class)
	public User findOne(@PathVariable("id") int id) {
		if(userService.findById(id) == null)
			try {
				throw new UserNotFoundException(id);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		
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
