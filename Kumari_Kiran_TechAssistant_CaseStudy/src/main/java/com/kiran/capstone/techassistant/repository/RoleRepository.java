package com.kiran.capstone.techassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.capstone.techassistant.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findById(int roleId);
}
