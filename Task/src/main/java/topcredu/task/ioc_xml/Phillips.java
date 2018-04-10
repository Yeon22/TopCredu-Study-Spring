package topcredu.task.ioc_xml;

public class Phillips implements CoffeeMaker {

	public Phillips() {}
	
	@Override
	public void coffeeExtract() {
		System.out.println("Phillips make coffee");
	}

}
