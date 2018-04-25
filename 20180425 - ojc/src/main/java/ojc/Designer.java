package ojc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 2)
public class Designer implements Emp {

	public void work() {
		System.out.println("Designer Working...");
	}

}
