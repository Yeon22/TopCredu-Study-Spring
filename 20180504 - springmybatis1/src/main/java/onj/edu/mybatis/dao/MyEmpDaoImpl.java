package onj.edu.mybatis.dao;

import org.springframework.beans.factory.annotation.Autowired;

import onj.edu.mybatis.model.MyEmp;

public class MyEmpDaoImpl implements MyEmpDao {
//	@Resource(name="sqlSession")
//	private SqlSession sqlSessionTemplate;
	
	//Mapper Interface
	@Autowired
	MyEmpDao myEmpDao;
	
	@Override
	public MyEmp getMyEmp(int empno) {
//		MyEmpDao myEmpDao = sqlSessionTemplate.getMapper(MyEmpDao.class);
		return myEmpDao.getMyEmp(empno);
	}

	@Override
	public int setMyEmp(MyEmp myEmp) {
//		MyEmpDao myEmpDao = sqlSessionTemplate.getMapper(MyEmpDao.class);
		return myEmpDao.setMyEmp(myEmp);
	}

	@Override
	public int updateMyEmp(MyEmp myEmp) {
//		MyEmpDao myEmpDao = sqlSessionTemplate.getMapper(MyEmpDao.class);
		return myEmpDao.updateMyEmp(myEmp);
	}

}
