package onj.hello.aop2;

public class SmallMart implements SmallMartInterface {

	@Override
	public void getProducts(String productName) throws Exception {
		System.out.println("[Target Method]getProduct()..." + productName);
//		throw new Exception("error...");
	}

}
