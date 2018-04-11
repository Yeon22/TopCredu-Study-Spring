package onj.hello.aop;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLoggingAdvice implements ThrowsAdvice {
	public void afterThrowing(Throwable throwable) {
		System.out.println("에러 발생...");
	}
}
