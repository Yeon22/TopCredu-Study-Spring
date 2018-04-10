package topcredu.task.DI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public List<Product> getProducts(){
		return productService.listProducts();
	}
}
