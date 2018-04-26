package onj.spel.injection;

public class Onj {
	private String name = "Onj";
	private String age = "10";
	
	/*
	 * app-context2.xml에서 SpelInjectionExam에 값을 주입하기 위해 getter만 만듬
	 * #{onj.name} 구문에 의해 getter가 호출되고 그 값이 SpellInjectionExam에 주입된다.
	 */
	
	public String getName() {
		return name;
	}
	
	public String getAge() {
		return age;
	}
}
