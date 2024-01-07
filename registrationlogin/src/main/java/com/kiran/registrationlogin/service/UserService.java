package com.kiran.registrationlogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kiran.registrationlogin.dto.UserDTO;

public interface UserService  extends UserDetailsService { public UserDetails loadUserByUsername(String userName);
public void creat(UserDTO userDTO);
public User findUserByEmail(String email);
public User findUserByName(String name);



}
