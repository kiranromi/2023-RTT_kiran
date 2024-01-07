package com.kiran.registrationlogin.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kiran.registrationlogin.entities.Role;
import com.kiran.registrationlogin.entities.User;

public class UserPrincipal implements UserDetails {
 
	 private User user;
	 private List<Role> roles;
	 public UserPrincipal(User user, List<Role> roles) {
	 super();
	 this.user = user;
	 this.roles = roles;
	 }
	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	 return roles.stream().map(role-> new
	 SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	 }
	 @Override
	 public String getPassword() {
	 return this.user.getPassword();
	 }
	 @Override
	 public String getUsername() {
	 return this.user.getEmail();
	 }
	 @Override
	 public boolean isAccountNonExpired() {
	 return true;
	 }
	 @Override
	 public boolean isAccountNonLocked() {
	 return true;
	 }
	 @Override
	 public boolean isCredentialsNonExpired() {
	 return true;
	 }
	 @Override
	 public boolean isEnabled() {
	 return true;
}
}
	 
