package onj.spel.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("sample")
public class SpelInjectionExam {
	private String name;
	private String age;
	
	//Onj객체의 getName을 호출해 값을 세팅
	@Value("#{onj.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	//Onj객체의 getAge를 호출해 값을 세팅
	@Value("#{onj.age}")
	public void setAge(String age) {
		this.age = age;
	}
	
	public String toString() {
		return "This is spel injection example... " + "Your name is " + name + ", age is " + age;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context3.xml");
		ctx.refresh();
		
		SpelInjectionExam sample = (SpelInjectionExam)ctx.getBean("sample");
		System.out.println(sample);
	}

}
