package edu.biz.ioc5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {
	@Autowired //TYPE이 CarMaker인 것 찾아 자동 주입, 여러개인 경우 Qualifier로 지정
	@Qualifier("daewoo")
	private CarMaker maker;
	
	@Autowired //TYPE이 Money인 것을 찾아 자동 주입
	private Money money;
	
	public OrderManager() {}
	
	public void order() {
		money.setAmount(1000);
		Car car = this.maker.sell(money);
	}
}
