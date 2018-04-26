package com.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " : �������");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " : �������");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("[�ֺ����] ���� �ð� : " + start/1000.0 + " ��");
		
		Object obj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println("[�ֺ����] ���� �ð� : " + end/1000.0 + " ��");
		
		
		return obj;
	}
}
