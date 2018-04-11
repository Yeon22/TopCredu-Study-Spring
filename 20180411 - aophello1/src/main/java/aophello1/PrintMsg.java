package aophello1;

public class PrintMsg implements IprintMsg{
	//Target 클래스, 횡단관심사 기능을 구현한 클래스.
	public String sayHello() {
//		System.out.println("Hello AOP...");
		return "Hello AOP...";
	} 
	
}
