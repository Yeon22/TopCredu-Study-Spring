package com.devglan.userportal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
	@ExceptionHandler({Exception.class, RuntimeException.class})
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		System.out.println(req.getRequestURL());
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Sorry, we couldnt't find what you are looking for." + ex.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		
		return mav;
	}
}
