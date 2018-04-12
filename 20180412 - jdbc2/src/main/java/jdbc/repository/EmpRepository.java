package jdbc.repository;

import java.util.List;

import jdbc.domain.Emp;

public interface EmpRepository {
	List<Emp> findAll();
	Emp findOne(Long empno);
	Emp save(Emp emp);
	void delete(Long empno);
}
