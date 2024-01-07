package com.kiran.thestudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kiran.thestudent.model.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>
 {
	 Role findByName(String name);
 }


