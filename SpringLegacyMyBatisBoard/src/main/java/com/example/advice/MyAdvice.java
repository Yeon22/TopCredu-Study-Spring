package com.example.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ModelAttribute;

@EnableAspectJAutoProxy
@Aspect
@Component
public class MyAdvice {
	@Autowired
	AdviceMapper adviceMapper;
	
	@ModelAttribute("active")
	public String active() {
		return "AdviceModel";
	}
	
	protected Log log = LogFactory.getLog((AdviceModel.class));
	public MyAdvice() {
		System.out.println("--------------------------------Aspect-------------------------------");
	}
	
	@Around("execution(* com.example.web.controller.BoardController.postInsert(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		Double elapseTimeBySecond = stopWatch.getTotalTimeSeconds();
		System.out.println("------------------- postInsert() 메소드 소요시간 = " + elapseTimeBySecond + " 초 -------------------------------");
		
		AdviceModel adviceModel = new AdviceModel();
		adviceModel.setName("수연");
		adviceModel.setPointcut("pointInset()");
		adviceModel.setElapsedtime(elapseTimeBySecond + " 초");
		adviceMapper.insert(adviceModel);
		
		return obj;
	}
	
//	public Object around(ProceedingJoinPoint pjp) throws Throwable {
//		String findName = pjp.getSignature().getName();
//		
//		long longstart = System.currentTimeMillis();
//		int starttime = (int) (longstart / 1000.0 );
//		System.out.println("[주변충고] getName : " + findName + " / 시작 시간 : " + starttime/1000.0 + " 초");
//		
//		Object obj = pjp.proceed();
//		System.out.println("obj : " + obj);
//		
//		long longend = System.currentTimeMillis();
//		int endtime = (int) (longend / 1000.0);
//		System.out.println("[주변충고]  getName : " + findName + " / 종료 시간 : " + endtime/1000.0 + " 초");
//		
//		return obj;
//	}
}
