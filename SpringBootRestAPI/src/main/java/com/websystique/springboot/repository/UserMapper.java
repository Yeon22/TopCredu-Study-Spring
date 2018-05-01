package com.websystique.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.websystique.springboot.model.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user ORDER BY id ASC")
	@ResultType(User.class)
	List<User> findAllUsers();
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	User findById(long id);
	
	boolean isUserExist(User user);
	
	@Insert("INSERT INTO user(name, age, salary) VALUES(#{name}, #{age}, #{salary})")
	void saveUser(User user);
	
	@Update("UPDATE user SET name = #{name}, age = #{age}, salary = #{salary} WHERE id = #{id}")
	void updateUser(User currentUser);
	
	@Delete("DELETE FROM user WHERE id = #{id}")
	void deleteUserById(long id);
	
	@Delete("DELETE FROM user")
	void deleteAllUsers();
}
