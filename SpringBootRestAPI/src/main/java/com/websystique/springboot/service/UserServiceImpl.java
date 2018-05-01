package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springboot.model.User;
import com.websystique.springboot.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public User findById(long id) {
		return userMapper.findById(id);
	}

	@Override
	public boolean isUserExist(User user) {
		if(user == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	@Override
	public void updateUser(User currentUser) {
		userMapper.updateUser(currentUser);
	}

	@Override
	public void deleteUserById(long id) {
		userMapper.deleteUserById(id);
	}

	@Override
	public void deleteAllUsers() {
		userMapper.deleteAllUsers();
	}
}
