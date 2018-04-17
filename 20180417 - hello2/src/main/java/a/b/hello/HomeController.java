package a.b.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/insa", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("serverTime", "insa");
		return "home";
	}
	
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public String home2(Model model) {
		model.addAttribute("serverTime", "sale");
		return "home";
	}
	
}
