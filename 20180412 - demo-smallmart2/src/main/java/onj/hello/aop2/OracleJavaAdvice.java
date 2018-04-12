package onj.hello.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class OracleJavaAdvice {
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "(" + joinPoint.getArgs()[0] + ") : 사후충고");
	}
	
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "(" + joinPoint.getArgs()[0] + ") : 사전충고");
	}
	
	public void afterThrowing() {
		System.out.println("예외충고 발생...");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String findName = (String)pjp.getSignature().getName();
		String methodName = (String)pjp.getArgs()[0];
		System.out.println("[주변충고]" + findName + "(" + methodName + ") 메소드 실행전");
		//타겟클래스의 메소드 호출
		Object obj = pjp.proceed();
		System.out.println("[주변충고]" + findName + "(" + methodName + ") 메소드 실행후");
		
		return obj;
	}
}
