package onj.hello.aop1;

public class SmallMart implements SmallMartInterface {

	public void getProducts(String productName) throws Exception {
		System.out.println("getProduct()..."+productName);
//		throw new Exception("error");
	}

	public void getProducts2(String productName) throws Exception {
		System.out.println("getProduct2()..."+productName);
//		throw new Exception("error");
	}

}
