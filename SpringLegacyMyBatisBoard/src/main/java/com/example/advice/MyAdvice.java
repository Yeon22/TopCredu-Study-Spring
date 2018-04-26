package com.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "(" + joinPoint.getArgs()[0] + ") : �������");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "(" + joinPoint.getArgs()[0] + ") : �������");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String findName = (String)pjp.getSignature().getName();
		String methodName = (String)pjp.getArgs()[0];
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		
		System.out.println("[�ֺ����] " + findName + ", �޼ҵ� �̸� : " + methodName + "���� �ð� : " + start/1000.0 + "��");
		Object obj = pjp.proceed();
		System.out.println("[�ֺ����] " + findName + ", �޼ҵ� �̸� : " + methodName + "���� �ð� : " + end/1000.0 + "��");
		
		
		return obj;
	}
}
