package jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdbc.service.EmpService;

@Controller
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("emps", empService.getEmpAll());
		return "emp";
	}
}
