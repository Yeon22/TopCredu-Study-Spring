package topcredu.task.java_configure;

import org.springframework.stereotype.Service;

@Service("wizwell")
public class WizWell implements CoffeeMaker {
	
	public void coffeeExtrct() {
		System.out.println("WizWell make coffee");
	}

}
