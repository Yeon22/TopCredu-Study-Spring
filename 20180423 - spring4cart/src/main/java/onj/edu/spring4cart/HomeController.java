package onj.edu.spring4cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/") //생략가능
@SessionAttributes({"cart"})
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCart(Model model) {
		if(!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<Goods>());
		}
		
		return "home";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute Goods goods, @ModelAttribute("cart") List<Goods> cart) {
		cart.add(goods);
		
		return "redirect:/";
	}
	
}
