package com.devglan.userportal;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository {
	void delete(User user);
	List findAll();
	User findOne(int id);
	User save(User user);
}
