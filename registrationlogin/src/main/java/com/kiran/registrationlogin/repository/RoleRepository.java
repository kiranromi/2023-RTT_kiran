package com.kiran.registrationlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiran.registrationlogin.entities.Role;
@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{
	
	 public Role findRoleByName(String role);
	 

	 @Query("SELECT r FROM Role r WHERE r.id = (SELECT ur.role.id FROM UserRoles ur WHERE ur.user.id = :id)")
	 List<Role> findRolesByUserId(@Param("id") Long userId);


			 		
	 public List<Role> findRoleByUser(@Param("id") long id);
}
