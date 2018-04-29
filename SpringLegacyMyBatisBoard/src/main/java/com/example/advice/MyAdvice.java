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
		System.out.println("------------------- postInsert() �޼ҵ� �ҿ�ð� = " + elapseTimeBySecond + " �� -------------------------------");
		
		AdviceModel adviceModel = new AdviceModel();
		adviceModel.setName("����");
		adviceModel.setPointcut("pointInset()");
		adviceModel.setElapsedtime(elapseTimeBySecond + " ��");
		adviceMapper.insert(adviceModel);
		
		return obj;
	}
	
//	public Object around(ProceedingJoinPoint pjp) throws Throwable {
//		String findName = pjp.getSignature().getName();
//		
//		long longstart = System.currentTimeMillis();
//		int starttime = (int) (longstart / 1000.0 );
//		System.out.println("[�ֺ����] getName : " + findName + " / ���� �ð� : " + starttime/1000.0 + " ��");
//		
//		Object obj = pjp.proceed();
//		System.out.println("obj : " + obj);
//		
//		long longend = System.currentTimeMillis();
//		int endtime = (int) (longend / 1000.0);
//		System.out.println("[�ֺ����]  getName : " + findName + " / ���� �ð� : " + endtime/1000.0 + " ��");
//		
//		return obj;
//	}
}
