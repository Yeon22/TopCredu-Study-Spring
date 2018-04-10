package topcredu.task.java_configure2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value= {"topcredu.task.java_configure2"})
public class DIConfiguration {
	
	@Bean
	public MessageService getMessageService() {
		return new TwitterService();
	}
	
}
