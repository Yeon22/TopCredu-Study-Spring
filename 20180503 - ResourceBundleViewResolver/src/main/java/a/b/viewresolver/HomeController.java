package a.b.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/info")
	public String home(Model model) {
		model.addAttribute("msg", "ResourceBundleViewResolver Demo");
		return "home"; //리소스 번들(프로퍼티) 파일에 뷰 클래스를 지정한다.
	}
	
	@RequestMapping("/home")
	public String getInfo() {
		return "refer";
	}
	
}
