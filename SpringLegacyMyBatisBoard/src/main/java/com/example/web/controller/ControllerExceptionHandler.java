package com.example.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception e) {
		ModelAndView mav = new ModelAndView("error/error");
		mav.addObject("errorMsg", e.getMessage());
		return mav;
	}

}
