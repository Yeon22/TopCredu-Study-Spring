package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.dto.Login;
import com.example.user.model.User;
import com.example.user.repository.UserMapper;

@Service
public class LoginService {
	@Autowired
	private UserMapper userMapper;

	public void authenticate(Login login) {
		User user = userMapper.selectByEmail(login.getEmail());
		if (user == null) {
			login.setError("Email does not exist.");
		} else {
			if (!user.getPassword().equals(login.getPassword())) {
				login.setError("Password is not correct.");
			} else {
				login.setError(null);
			}
		}
	}
}
