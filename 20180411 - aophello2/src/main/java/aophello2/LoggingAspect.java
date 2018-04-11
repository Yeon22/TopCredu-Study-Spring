package aophello2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect { //Aspect클래스로 충고용 메소드 및 포인트컷을 정의한다.
	
	@Around("execution(* aophello2.PrintMsg.sayHello1())")
	public void myAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("메소드 실행전 안녕..."); //메소드 실행 전
		Object ret = pjp.proceed();
		System.out.println("메소드 실행후 안녕..."); //메소드 실행 후
	}
	
}
