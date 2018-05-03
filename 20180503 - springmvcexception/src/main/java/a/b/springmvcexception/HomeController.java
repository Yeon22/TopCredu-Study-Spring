package a.b.springmvcexception;

import java.io.IOException;

import org.springframework.stereotype.Controller;
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
	
}
