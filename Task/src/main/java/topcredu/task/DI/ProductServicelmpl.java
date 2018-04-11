package topcredu.task.DI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("productServicelmpl")
public class ProductServicelmpl implements ProductService{

	public List<Product> listProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product("Product 1 description"));
		products.add(new Product("Product 2 description"));
		return products;
	}
	
}
