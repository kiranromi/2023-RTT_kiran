package com.kiranCapstone.ia.util;

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

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String authorization = httpRequest.getHeader("authorization");
		if(null != authorization && !authorization.isBlank()) {
			httpRequest.setAttribute("role", UserSessionHandler.getRoleByToken(authorization));
		} else if(httpRequest.getAttribute("authorization") != null) {
			authorization = (String) httpRequest.getAttribute("authorization");
			httpRequest.setAttribute("role", UserSessionHandler.getRoleByToken(authorization));
		}
		String url = ((HttpServletRequest)request).getRequestURL().toString();

		chain.doFilter(request, response);
//		httpResponse.getHeader("authorization")
//		httpRequest.getHeader("authorization");
//		httpRequest.getAttribute("authorization")
		if (null == authorization || authorization.isBlank()) {
			
			if (httpResponse.getHeader("authorization") != null) {
//				During login and redirect
				httpRequest.setAttribute("authorization", httpResponse.getHeader("authorization"));
				httpResponse.setHeader("role", UserSessionHandler.getRoleByToken(authorization));
			}
		} else {
			httpResponse.setHeader("authorization", authorization);
			httpResponse.setHeader("role", UserSessionHandler.getRoleByToken(authorization));
		}

	}

}
