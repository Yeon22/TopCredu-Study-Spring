package a.b.flashattr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	//�Է�ȭ���� ����.
	@RequestMapping(value = "addform", method = RequestMethod.GET)
	public String showForm(@ModelAttribute("emp") Emp emp) {
		return "addemp";
	}
	
	//�Է�ȭ�鿡�� "Add Emp"��ư Ŭ���� ȣ���
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("emp") Emp emp, final RedirectAttributes rAttr) {
		//�����̷�Ʈ�� ������ ��� Flash ������ �ӽ÷� emp, msg�� �����Ѵ�.
		rAttr.addFlashAttribute("emp", emp);
		rAttr.addFlashAttribute("msg", "added success!");
		
		return "redirect:showemp.html";
	}
	
	@RequestMapping(value = "showemp", method = RequestMethod.GET)
	public String showCustomer(@ModelAttribute("emp") Emp emp) {
		//�������� ���ε��ϴ� ��� emp.getName, emp.getAge ��� NULL�� �Ѿ�´�.
		System.out.println("emp : " + emp.getName() + ", " + emp.getAge());
		return "show";
	}
	
}
