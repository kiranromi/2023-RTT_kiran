package com.kiran.capstone.techassistant.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kiran.capstone.techassistant.constant.UserRole;
import com.kiran.capstone.techassistant.entity.User;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object handler,
			ModelAndView modelAndView) throws Exception {

		String authorization = httpRequest.getParameter("authorization");
		if (null == authorization) {
			authorization = httpRequest.getHeader("authorization");
			if (null == authorization) {
				authorization = (String) httpRequest.getAttribute("authorization");
				if (authorization == null || authorization.isBlank()) {
					authorization = httpResponse.getHeader("authorization");
				}
			}
		}

		String role = UserSessionHandler.getRoleByToken(authorization);
		User user = UserSessionHandler.getUserByToken(authorization);
		if (user != null) {
			String name = user.getFirstName();
			if (UserRole.EMPLOYER.name().equalsIgnoreCase(role)) {
				name = user.getEmployerName();
			}

			if (modelAndView != null) {
				modelAndView.addObject("role", role);
				modelAndView.addObject("userId", user.getId());
				modelAndView.addObject("authorization", authorization);
				modelAndView.addObject("name", name);
			}

			httpResponse.setHeader("role", role);
			httpResponse.setHeader("userId", user.getId().toString());
			httpResponse.setHeader("authorization", authorization);
			httpResponse.setHeader("name", name);
		}

	}

}
