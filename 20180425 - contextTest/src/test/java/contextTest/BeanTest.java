package contextTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanA.class, BeanB.class})
public class BeanTest {
	@Autowired
	private BeanA a;
	
	@Autowired
	private BeanB b;
	
	@Test
	public void test() {
		assertNotNull(a);
		assertNotNull(b);
	}

}
