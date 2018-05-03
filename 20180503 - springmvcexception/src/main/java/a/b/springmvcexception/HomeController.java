package a.b.springmvcexception;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String hello() throws IOException {
		// 뷰이름 이름, hello.jsp 호출
		return "home";
	}
	
	@RequestMapping(value = "/test")
	public String test() throws IOException {
		{
			throw new IOException("occured IOException...");
		}
	}
	
	@RequestMapping(value = "/hello.html")
	public String hello2(@CookieValue(value = "onjCounter", defaultValue = "0") Integer onjCounter, HttpServletResponse response) {
		//쿠키값을 일어 우선 counter, 1증가
		onjCounter++;
		
		//응답에 쿠키를 셋팅
		Cookie cookie = new Cookie("onjCounter", onjCounter.toString());
		response.addCookie(cookie);
		
		//view이름
		return "cookie";
	}
	
}
