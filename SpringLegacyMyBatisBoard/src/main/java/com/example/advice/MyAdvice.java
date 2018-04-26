package com.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "(" + joinPoint.getArgs()[0] + ") : 사전충고");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "(" + joinPoint.getArgs()[0] + ") : 사후충고");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String findName = (String)pjp.getSignature().getName();
		String methodName = (String)pjp.getArgs()[0];
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		
		System.out.println("[주변충고] " + findName + ", 메소드 이름 : " + methodName + "시작 시간 : " + start/1000.0 + "초");
		Object obj = pjp.proceed();
		System.out.println("[주변충고] " + findName + ", 메소드 이름 : " + methodName + "종료 시간 : " + end/1000.0 + "초");
		
		
		return obj;
	}
}
