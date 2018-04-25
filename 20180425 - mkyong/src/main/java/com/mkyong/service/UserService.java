package com.mkyong.service;

import com.mkyong.dao.UserDAO;

public class UserService {
	UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String toString() {
		return "UserService [userDao=" + userDao + "]";
	}
}
