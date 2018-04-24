package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import model.Emp;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao {
	@Resource(name="sqlSession")
	private SqlSession sqlSessionTemplate;
	
	@Override
	public List<Emp> getEmpAll() throws DataAccessException {
		EmpDao dao = sqlSessionTemplate.getMapper(EmpDao.class);
		List<Emp> empList = null;
		empList = dao.getEmpAll();
		
		return empList;
	}

}
