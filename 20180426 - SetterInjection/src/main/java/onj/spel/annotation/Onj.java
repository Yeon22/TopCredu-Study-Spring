package onj.spel.annotation;

import org.springframework.stereotype.Component;

@Component
public class Onj {
	private String name = "Onj";
	private String age = "10";
	
	public String getName() {
		return name;
	}
	
	public String getAge() {
		return age;
	}
}
