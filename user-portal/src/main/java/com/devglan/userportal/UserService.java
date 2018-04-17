package com.devglan.userportal;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface UserService {
	public User create(User user);
	public User delete(int id);
	public List findAll();
	public User findById(int id);
	public User update(User user);
}
