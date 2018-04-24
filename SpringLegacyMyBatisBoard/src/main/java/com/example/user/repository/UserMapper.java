package com.example.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.user.model.User;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO xuser(email, password) VALUES(#{email}, #{password})")
	public int insert(User user);

	@Update("UPDATE xuser SET password = #{password} WHERE email = #{email}")
	public int update(User user);

	@Delete("DELETE FROM xuser WHERE email = #{email}")
	public int delete(String email);

	@Select("SELECT COUNT(*) FROM xuser")
	public int count();

	@Select("SELECT * FROM xuser ORDER BY email ASC")
	// 생략이 가능하다. 생략하면 아래 선언이 있는 것처럼 작동한다.
	@ResultType(User.class) 
	public List<User> selectAll();

	@Select("SELECT * FROM xuser WHERE email = #{email}")
	// 선언해 놓으면 다른 메소드에서 @ResultMap("userResultMap") 선언으로 이용할 수 있다.
	@Results(id = "userResultMap", value = { 
			@Result(property = "email", column = "email"),
			@Result(property = "password", column = "password") })
	public User selectByEmail(String email);
}
