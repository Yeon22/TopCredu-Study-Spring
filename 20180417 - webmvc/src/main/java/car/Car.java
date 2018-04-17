package car;

public class Car {
	private String name;
	
	public Car(String name) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Car created!");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
