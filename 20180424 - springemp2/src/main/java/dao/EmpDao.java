package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Emp;

public interface EmpDao {
	public List<Emp> getEmpAll() throws DataAccessException;
}
