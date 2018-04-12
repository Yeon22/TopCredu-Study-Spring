package onj.hello.aop3;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SmallMartAspect {
	@Pointcut("execution(* onj.hello.aop3.SmallMartInterface.getProducts(..))")
	public void getProduct1() {}
	
	@Pointcut("args(String)")
	public void getProduct2() {}
	
	//사전충고 : 타겟클래스의 메소드 실행 전 충고실행
	@Before("getProduct1() && getProduct2()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before Advice --> logBefore()...");
		joinPoint.getSignature().getName();
	}
	
	//사후충고(after) : 타겟클래스의 메소드 실행 후 충고 실행, 오류가 발생해도 실행
	@After("getProduct1()")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After Advice --> logAfter()...");
		joinPoint.getSignature().getName();
	}
	
	//사후충고(after returning) : 타겟클래스의 메소드 정상 리턴된 후 실행
	//returning 속성으로 리턴값을 받을 수 있다.
	@AfterReturning(pointcut = "getProduct1()", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("AfterReturning Advice --> logAfterReturning()...");
		joinPoint.getSignature().getName();
		System.out.println("return value is " + result);
	}
	
	//주변충고 : 타겟클래스의 메소드 실행 전후에 충고 실행
	@Around("getProduct1()")
	public String logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around Advice[전] --> logAround()...");
		joinPoint.getSignature().getName();
		Arrays.toString(joinPoint.getArgs());
		
		//타겟 객체의 원래 메소드 실행
		String s = (String)joinPoint.proceed();
		
		System.out.println("Around Advice[후] --> logAround()...");
		//원래 타겟클래스의 메소드 리턴값을 대체시킴
		return "이 문장으로 원래 타겟메소드(getProducts) 리턴이 대체됨!!";
	}
	
	//예외충고 : 예외가 발생될 때 충고 실행
	@AfterThrowing(pointcut = "getProduct1()", throwing = "error")
	//error는 실행되는 메소드에서 던지는 예외객체
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("예외충고 --> logAfterThrowing()...");
		joinPoint.getSignature().getName();
		System.out.println("Exception " + error);
	}
}
