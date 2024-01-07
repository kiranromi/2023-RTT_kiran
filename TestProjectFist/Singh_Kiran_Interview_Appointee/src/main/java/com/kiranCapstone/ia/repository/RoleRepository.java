package com.kiranCapstone.ia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiranCapstone.ia.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findById(int roleId);
}
