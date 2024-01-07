//package com.kiranCapstone.ia.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.access.AccessDeniedHandlerImpl;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests(requests -> requests
//				.antMatchers("/", "/home", "/register", "/login", "/processLogin", "/processRegistration").permitAll()
//				.anyRequest().authenticated())
//				.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/dashboard").permitAll())
//				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")).csrf(csrf -> csrf.disable());
//	}
//
//	@Bean
//	public AccessDeniedHandler accessDeniedHandler() {
//	    AccessDeniedHandlerImpl handler = new AccessDeniedHandlerImpl();
//	    handler.setErrorPage("/access-denied");
//	    return handler;
//	}
//	
//}
