package com.kiranCapstone.ia.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kiranCapstone.ia.util.UserSessionHandler;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object handler,
			ModelAndView modelAndView) throws Exception {

		String authorization = httpRequest.getHeader("authorization");
		if (authorization == null || authorization.isBlank()) {
			authorization = httpResponse.getHeader("authorization");
			if (authorization == null || authorization.isBlank()) {
				authorization = (String) httpRequest.getAttribute("authorization");
			}
		}
		modelAndView.addObject("role", UserSessionHandler.getRoleByToken(authorization));

	}

}
