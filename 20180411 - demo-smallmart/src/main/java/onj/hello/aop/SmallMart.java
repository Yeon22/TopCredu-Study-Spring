package onj.hello.aop;

public class SmallMart implements SmallMartInterface{

	@Override
	public void getProducts(String productName) throws Exception {
		System.out.println("[Target Method]getProduct()..." + productName);
//		throw new Exception("error..."); 
	}

}
