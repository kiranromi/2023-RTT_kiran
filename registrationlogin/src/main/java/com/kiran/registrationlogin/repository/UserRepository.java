package com.kiran.registrationlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.registrationlogin.entities.User;




@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	 public User findUserByEmail(String email);
	 public User findUserByUserName(String name);
}
