package ojc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderTest {

	@Autowired
	List<Emp> emps;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("order.xml");
		OrderTest test = (OrderTest) context.getBean("orderTest");
		
		for(Emp e : test.emps) {
			e.work();
		}
	}

}
