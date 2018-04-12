package onj.hello.aop3;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSmallMart3Application implements CommandLineRunner{

	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoSmallMart3Application.class, args);
	}

	@Inject
	private SmallMartInterface smallMart;
	public void run(String... args) throws Exception {
		this.smallMart.getProducts("과자");
	}
}
