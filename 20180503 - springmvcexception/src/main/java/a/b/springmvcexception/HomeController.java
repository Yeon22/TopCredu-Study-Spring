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
		// ���̸� �̸�, hello.jsp ȣ��
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
		//��Ű���� �Ͼ� �켱 counter, 1����
		onjCounter++;
		
		//���信 ��Ű�� ����
		Cookie cookie = new Cookie("onjCounter", onjCounter.toString());
		response.addCookie(cookie);
		
		//view�̸�
		return "cookie";
	}
	
}
