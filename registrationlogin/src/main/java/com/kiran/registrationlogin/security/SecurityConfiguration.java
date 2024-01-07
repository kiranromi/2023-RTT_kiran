package com.kiran.registrationlogin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userServiceImpl); // Set the custom user details service
        authProvider.setPasswordEncoder(passwordEncoder()); // Set the password encoder - bcrypt
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

@Bean
protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests(
(auth)-> auth
.requestMatchers("/", "/login*",
"/css/*", "/js/*", "/sign-up",
"/signup-process").permitAll()
.requestMatchers("/home").hasAnyRole("USER", "ADMIN")
.anyRequest().authenticated()
)
.formLogin(form-> form
.loginPage("/login")
.loginProcessingUrl("/login") // should point to login page
.successForwardUrl("/home") // must be in order thymeleaf security extras work

.permitAll()
)
.logout(
logout-> logout
.invalidateHttpSession(true)
.clearAuthentication(true)
.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
.permitAll()
);
return http.build();
}

}
