package edu.biz.ioc4;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {
	@Inject
	@Named("daewoo")
//	@Resource(name="daewoo")
	private CarMaker maker;
	
	@Resource(name="money") //TYPE이 Money인 것을 찾아 자동 주입
	private Money money;
	
	public OrderManager() {}
	
	public void order() {
		money.setAmount(1000);
		Car car = this.maker.sell(money);
	}
}
