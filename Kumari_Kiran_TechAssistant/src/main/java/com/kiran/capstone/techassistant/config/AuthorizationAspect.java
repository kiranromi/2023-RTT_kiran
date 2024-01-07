package com.kiran.capstone.techassistant.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

	@Autowired
	private HttpServletRequest request;

	@Before("@annotation(Authorization)")
	public void beforeAdvice(JoinPoint joinPoint) throws Exception {

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Authorization authorization = method.getAnnotation(Authorization.class);
		String[] roles = authorization.roles();
		if(roles.length ==0) {
			return;
		}
		String userRole = UserSessionHandler.getRoleByToken(request.getParameter("authorization"));
		for (String r : roles) {
			if (r.equalsIgnoreCase(userRole)) {
				return;
			}
		}
		System.out.println("Not authorize to take this action");
		throw new Exception("Not authorize to take this action");
	}
}
