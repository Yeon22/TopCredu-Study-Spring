package ojc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 1)
public class Programmer implements Emp {

	public void work() {
		System.out.println("Programmer Working...");
	}

}
