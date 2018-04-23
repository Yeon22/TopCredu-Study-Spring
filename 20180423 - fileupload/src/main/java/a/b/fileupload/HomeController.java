package a.b.fileupload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayForm() {
		return "fileupload";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileForm uploadForm, Model map) throws Exception {
		List<MultipartFile> files = uploadForm.getFiles();
		
		//success.jsp로 보낼 파일 이름 저장
		List<String> fileNames = new ArrayList<String>();
		
		if(null != files && files.size() > 0) {
			for(MultipartFile multipartFile : files) {
				String fileName = multipartFile.getOriginalFilename();
				String path = uploadForm.getUpDir() + fileName;
				File f = new File(path);
				multipartFile.transferTo(f);
				fileNames.add(fileName);
			}
		}
		
		map.addAttribute("files", fileNames);
		return "success";
	}
	
}
