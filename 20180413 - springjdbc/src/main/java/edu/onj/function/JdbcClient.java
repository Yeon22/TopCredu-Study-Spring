package edu.onj.function;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("jdbc.xml");
		ctx.refresh();
		
		EmpDaoImpl empDao = (EmpDaoImpl)ctx.getBean("empDao");
		
		//1.EMP TABLE에서 부서코드가 10인 데이터 추출
		List<Emp> emps = empDao.listEmp(10);
		System.out.println("-----------------------all select-----------------------");
		for(Emp emp : emps) {
			System.out.println("empno-->" + emp.getEmpno());
			System.out.println("ename-->" + emp.getEname());
			System.out.println("sal-->" + emp.getSal());
		}
		emps.clear();
		
		//2.BatchPreparedStatementSetter를 이용하여 List에 있는것을 일괄 INSERT
		emps.add(new Emp("4711", "1001 ins1", "10010"));
		emps.add(new Emp("4712", "1002 ins2", "10020"));
		emps.add(new Emp("4713", "1003 ins3", "10030"));
		emps.add(new Emp("4714", "1004 ins4", "10040"));
		emps.add(new Emp("4715", "1005 ins5", "10050"));
		empDao.createEmpList(emps);
		System.out.println(emps);
		
		//3.Spring JDBC SimpleJdbcCall을 이용한 오라클 함수(ref cursor 리턴)호출을 통한 10번 부서 EMP 호출
		ArrayList<Emp> emps2 = (ArrayList<Emp>)empDao.listEmp(new Integer(10));
		for(Emp e : emps2) {
			System.out.println(e.getEmpno() + ":" + e.getEname() + ":" + e.getSal());
		}
		ctx.close();
	}

}
