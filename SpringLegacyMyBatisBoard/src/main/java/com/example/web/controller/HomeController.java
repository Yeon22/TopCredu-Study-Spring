package com.example.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private static Logger logger = LoggerFactory.getLogger("HomeController");

	@GetMapping
	public String getHomeView(HttpServletRequest request) {
		logger.info("GET: " + request.getRequestURI());
		return "home";
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
