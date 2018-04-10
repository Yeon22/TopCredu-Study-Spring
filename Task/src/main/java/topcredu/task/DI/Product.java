package topcredu.task.DI;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private String description;
	
	public Product(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
