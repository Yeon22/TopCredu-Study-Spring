package com.example.websquare.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.websquare.model.Emp;

@Mapper
public interface EmpMapper {
	@Select("SELECT * FROM emp ORDER BY empno ASC")
	@ResultType(Emp.class)
	List<Emp> findAllEmps();
	
	@Select("SELECT * FROM emp WHERE empno = #{empno}")
	Emp findByEmpno(int empno);
	
	boolean isEmpExist(Emp emp);
	
	@Insert("INSERT INTO emp(name, job, salary) VALUES(#{name}, #{job}, #{salary}")
	void saveEmp(Emp emp);
	
	@Update("UPDATE emp SET name=#{name}, job=#{job}, salary=#{salary} WHERE empno=#{empno}")
	void updateEmp(Emp currentEmp);
	
	@Delete("DELETE FROM emp WHERE empno=#{empno}")
	void deleteEmpByEmpno(int empno);
	
	@Delete("DELETE FROM emp")
	void deleteAllEmps();
}
