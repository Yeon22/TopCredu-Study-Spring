package a.b.flashattr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	//입력화면을 띄운다.
	@RequestMapping(value = "addform", method = RequestMethod.GET)
	public String showForm(@ModelAttribute("emp") Emp emp) {
		return "addemp";
	}
	
	//입력화면에서 "Add Emp"버튼 클릭시 호출됨
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("emp") Emp emp, final RedirectAttributes rAttr) {
		//리다이렌트로 보내는 경우 Flash 영역에 임시로 emp, msg를 저장한다.
		rAttr.addFlashAttribute("emp", emp);
		rAttr.addFlashAttribute("msg", "added success!");
		
		return "redirect:showemp.html";
	}
	
	@RequestMapping(value = "showemp", method = RequestMethod.GET)
	public String showCustomer(@ModelAttribute("emp") Emp emp) {
		//페이지를 리로드하는 경우 emp.getName, emp.getAge 모두 NULL이 넘어온다.
		System.out.println("emp : " + emp.getName() + ", " + emp.getAge());
		return "show";
	}
	
}
