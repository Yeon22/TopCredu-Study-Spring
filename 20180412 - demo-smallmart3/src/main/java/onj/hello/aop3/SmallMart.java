package onj.hello.aop3;

import org.springframework.stereotype.Component;

@Component
public class SmallMart implements SmallMartInterface {

	@Override
	public String getProducts(String productName) throws Exception {
		return "[Target Method]getProduct()..." + productName;
		//throw new Exception("error...");
	}

}
