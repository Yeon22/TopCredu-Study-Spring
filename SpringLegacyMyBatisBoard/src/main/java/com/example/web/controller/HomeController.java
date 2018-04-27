package com.example.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.advice.AdviceMapper;
import com.example.advice.AdviceModel;

@Controller
public class HomeController {
	@Autowired
	private AdviceMapper adviceMapper;
	
	private static Logger logger = LoggerFactory.getLogger("HomeController");

	@GetMapping
	public String getHomeView(HttpServletRequest request) {
		logger.info("GET: " + request.getRequestURI());
		return "home";
	}
	
	@GetMapping("/aop")
	public ModelAndView getAOPview() {
		ArrayList<AdviceModel> aopResult = (ArrayList<AdviceModel>) adviceMapper.selectAll();
		ModelAndView view = new ModelAndView();
		view.setViewName("AOPview");
		view.addObject("aopResult", aopResult);
		
		return view;
	}

	@GetMapping("/404.html")
	public String get404View() {
		return "error/404";
	}

	@GetMapping("/throw")
	public String testControllerAdvice() {
		throw new RuntimeException("Error Test In Controller.");
	}
}
