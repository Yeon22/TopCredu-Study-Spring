package a.b.springmvcexception;

import java.io.IOException;

import org.springframework.stereotype.Controller;
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
	
}
