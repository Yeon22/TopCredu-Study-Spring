package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.User;

public interface UserService {
	List<User> findAllUsers();
	User findById(long id);
	boolean isUserExist(User user);
	void saveUser(User user);
	void updateUser(User currentUser);
	void deleteUserById(long id);
	void deleteAllUsers();
}
