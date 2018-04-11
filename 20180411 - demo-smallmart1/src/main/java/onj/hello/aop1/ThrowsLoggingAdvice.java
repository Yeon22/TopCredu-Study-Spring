package onj.hello.aop1;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLoggingAdvice implements ThrowsAdvice {
	public void afterThrowing(Throwable throwable) {
		System.out.println("예외 충고 발생...");
	}
}
