package topcredu.task.java_configure2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DIApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		app.processMessage("안녕 탑크리에듀", "webmaster@topcredu.co.kr");
	}

}
