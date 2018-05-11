package com.emp.server.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.server.model.Emp;
import com.emp.server.service.EmpServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600) //origins = "*" : 모든 접속 허용
@RestController
@RequestMapping("/api")
public class EmpRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmpRestController.class);
	
	@Autowired
	EmpServiceImpl empService;
	
	//모든 사원
	@PostMapping("/emp.post")
	public Map<Object, Object> getAllEmp() {
		Map<Object, Object> resObj = new HashMap<>();
		resObj.put("emp_userInfo", empService.getAllEmps());
		resObj.put("msg", "조회가 완료되었습니다.");
		resObj.put("msgCode", "S");
		
		return resObj;
	}
	
	@PostMapping("/searchMember.do")
	public Map<String, Object> searchMember(@RequestBody(required = true) Map param) throws Exception {
		Map<String, Object> resObj = new HashMap<String, Object>();
		Map sParam = null;
		Emp sMember = null;
		try {
			sParam = (Map)param.get("emp_searchParam");
			if(sParam == null) {
				throw new RuntimeException("필수 파라미터가 누락되었습니다.");
			}
			sMember = new Emp();
			sMember.setGender((String)sParam.get("gender"));
			sMember.setPosition((String)sParam.get("position"));
			
			resObj.put("emp_userInfo", empService.searchMember(sMember));
			resObj.put("msg", "조회가 완료되었습니다.");
			resObj.put("msgCode", "S");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resObj;
	}
	
	//사원 생성
	@PostMapping("/createEmp.do")
	public Map saveMember(@RequestBody(required = true) Map param) throws Exception {
		Map resObj = new HashMap();
		return resObj;
	}
}
