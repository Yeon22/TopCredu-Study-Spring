package contextTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanA {
	@Bean
	public String getA() {
		return "Hello I am BeanA";
	}
}
