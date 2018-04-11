package aophello1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogginAspect {
	public void myAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("메소드 실행전 안녕..."); //메소드 실행 전
		Object ret = pjp.proceed();
		System.out.println("메소드 실행후 안녕..."); //메소드 실행 후
	}
}
