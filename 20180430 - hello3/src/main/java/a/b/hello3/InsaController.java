package a.b.hello3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class InsaController {	
	private static final Logger logger = LoggerFactory.getLogger(InsaController.class);	
	
	@RequestMapping(value = "/insa", method = RequestMethod.GET)
	public String home(Model model) {			
		model.addAttribute("serverTime", "insa~~~" );
		logger.info("insa~~~~~~~~~~~~~~~~~~~");
		System.out.println("--------------------insa");
		return "home";
	}	
}
