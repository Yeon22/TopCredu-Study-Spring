package com.example.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.user.model.User;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			String url = session.getServletContext().getContextPath() + "/login";
			response.sendRedirect(url);
			System.out.println("LoginInterceptor # preHandle() : NO PASS");
			return false;
		}
		
		System.out.println("LoginInterceptor # preHandle() : PASS");
		return true;
	}
}
