package topcredu.task.java_configure2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MyApplication {
	//field-based dependency injection
	//@Autowired
	private MessageService service;

//	constructor-based dependency injection	
//	@Autowired
//	public MyApplication(MessageService svc){
//		this.service=svc;
//	}

	@Autowired //세터주입
	public void setService(MessageService svc){
		this.service = svc;
	}

	public boolean processMessage(String msg, String rec){
		//some magic like validation, logging etc
		return this.service.sendMessage(msg, rec);
	}
}
