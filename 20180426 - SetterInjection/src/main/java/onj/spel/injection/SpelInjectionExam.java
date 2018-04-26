package onj.spel.injection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpelInjectionExam {
	private String name;
	private String age;
	
	//빈 정의 xml에서 name이라는 Property의 value값을 주입 받음
	public void setName(String name) {
		this.name = name;
	}
	
	//빈 벙의 xml에서 age라는 Property의 value값을 주입 받음
	public void setAge(String age) {
		this.age = age;
	}
	
	public String toString() {
		return "This is spel injection example..." + "Your name is " + name + " age is " + age;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context2.xml");
		ctx.refresh();
		
		SpelInjectionExam sample = (SpelInjectionExam)ctx.getBean("sample");
		System.out.println(sample);
	}
}
