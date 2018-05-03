package a.b.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/info")
	public String home(Model model) {
		model.addAttribute("msg", "ResourceBundleViewResolver Demo");
		return "home"; //���ҽ� ����(������Ƽ) ���Ͽ� �� Ŭ������ �����Ѵ�.
	}
	
	@RequestMapping("/home")
	public String getInfo() {
		return "refer";
	}
	
}
