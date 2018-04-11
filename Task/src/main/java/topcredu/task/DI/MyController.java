package topcredu.task.DI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	private ProductServicelmpl productService;
	
	@Qualifier
	public void setProductService(ProductService productService) {
		this.productService = (ProductServicelmpl) productService;
	}
	
	public List<Product> getProducts(){
		return productService.listProducts();
	}
}
