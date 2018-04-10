package topcredu.task.ioc_xml;

public class CoffeeManager {
	private CoffeeMaker maker;
	
	public CoffeeManager(CoffeeMaker maker) {
		this.maker = maker;
	}
	
	public void setMaker(CoffeeMaker maker) {
		this.maker = maker;
	}
	
	public void order() {
		this.maker.coffeeExtract();
	}
}
