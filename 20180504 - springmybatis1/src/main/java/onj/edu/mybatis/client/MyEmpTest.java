package onj.edu.mybatis.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import onj.edu.mybatis.dao.MyEmpDao;
import onj.edu.mybatis.model.MyEmp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context/applicationContext-mybatis.xml")
public class MyEmpTest {
	@Autowired
	private MyEmpDao myEmpDao;
	
	@Test
	public void test() {
		MyEmp myEmp = myEmpDao.getMyEmp(1);
		System.out.println(myEmp.getEmpno());
		System.out.println(myEmp.getEname());
		
		myEmp.setEmpno(myEmp.getEmpno() + 1);
		myEmp.setEname("2길동");
		int ret = myEmpDao.setMyEmp(myEmp);
		System.out.println(ret);
		
		myEmp.setEmpno(1);
		myEmp.setEname("변경된이름");
		int ret2 = myEmpDao.updateMyEmp(myEmp);
		System.out.println(ret2);
	}
}
