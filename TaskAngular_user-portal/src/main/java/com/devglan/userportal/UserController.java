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
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping(path = {"/{id}"})
	public User findOne(@PathVariable("id") int id) {
		if(userService.findById(id) == null)
			try {
				throw new UserNotFoundException(id);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		
		return userService.findById(id);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView exHandler(HttpServletRequest request, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("error");
		
		return modelAndView;
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
