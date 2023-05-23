package com.springboot.springmvc.hotelmanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.springboot.springmvc.hotelmanagement.entity.User;
@Component
public class MyInterceptor implements HandlerInterceptor {

	public MyInterceptor() {
		// TODO Auto-generated constructor stub
	}

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session =request.getSession();
		User user=(User)session.getAttribute("user");
		
		if(user==null) {
			response.sendRedirect("/login");
			return false;
		}
		else {
			return true;
		}
		
}
}
