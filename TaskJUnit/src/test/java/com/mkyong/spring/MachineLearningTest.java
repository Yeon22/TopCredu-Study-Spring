package com.mkyong.spring;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.examples.spring.AppConfig;
import com.mkyong.examples.spring.DataModelSevice;
import com.mkyong.examples.spring.MachineLearningService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MachineLearningTest {
	//DI
	@Autowired
	@Qualifier("ml")
	DataModelSevice ml;
	
	@Test
	public void test_ml_always_return_true() {
		//assert correct type/impl
		assertThat(ml, instanceOf(MachineLearningService.class));
		
		//assert true
		assertThat(ml.isValid(""), is(true));
	}
}
