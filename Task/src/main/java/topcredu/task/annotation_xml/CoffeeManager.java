package topcredu.task.annotation_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("coffeeManager")
public class CoffeeManager {
	@Qualifier("phillips")
	
	@Autowired
	private CoffeeMaker maker;
	
	public CoffeeManager() {}
	
	public void order() {
		this.maker.coffeeExtrct();
	}
}
