package topcredu.task.annotation_xml;

import org.springframework.stereotype.Service;

@Service("phillips")
public class Phillips implements CoffeeMaker {
	
	public void coffeeExtrct() {
		System.out.println("Phillips make coffee");
	}

}
