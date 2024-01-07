package com.kiran.artcollectorregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.artcollectorregistration.model.Role;



public interface RoleRepository extends JpaRepository<Role,  Long> {
	 Role findByName(String name);

}

