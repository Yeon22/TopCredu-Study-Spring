package com.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " : 사전충고");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " : 사후충고");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("[주변충고] 시작 시간 : " + start/1000.0 + " 초");
		
		Object obj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println("[주변충고] 종료 시간 : " + end/1000.0 + " 초");
		
		
		return obj;
	}
}
