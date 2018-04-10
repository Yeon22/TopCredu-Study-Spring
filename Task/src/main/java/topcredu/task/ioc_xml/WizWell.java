package topcredu.task.ioc_xml;

public class WizWell implements CoffeeMaker {

	public WizWell() {}
	
	@Override
	public void coffeeExtract() {
		System.out.println("WizWell make coffee");
	}

}
