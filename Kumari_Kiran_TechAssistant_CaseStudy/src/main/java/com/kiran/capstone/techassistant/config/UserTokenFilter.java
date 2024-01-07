package com.kiran.capstone.techassistant.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class UserTokenFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

//		String url = ((HttpServletRequest)request).getRequestURL().toString();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String authorization = request.getParameter("interviewerId");
		if (null == authorization) {
			authorization = httpRequest.getHeader("authorization");
			if (null == authorization) {
				authorization = (String) httpRequest.getAttribute("authorization");
			}
		}
		httpRequest.setAttribute("role", UserSessionHandler.getRoleByToken(authorization));
		chain.doFilter(request, response);
		
		if (null == authorization || authorization.isBlank()) {
			if (httpResponse.getHeader("authorization") != null) {
				httpRequest.setAttribute("authorization", httpResponse.getHeader("authorization"));
				httpResponse.setHeader("role", UserSessionHandler.getRoleByToken(authorization));
			}
		} else {
			httpResponse.setHeader("authorization", authorization);
			httpRequest.setAttribute("authorization", authorization);
			httpResponse.setHeader("role", UserSessionHandler.getRoleByToken(authorization));
		}

	}

}
