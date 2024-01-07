package com.kiranCapstone.ia.constant;

import java.util.HashMap;
import java.util.Map;

import com.kiranCapstone.ia.entity.Role;

public enum UserRole {

	ADMIN(1), EMPLOYER(2), INTERVIEWER(3);

	int type;
 
	private static final Map<Integer, String> roleNameMapByType = new HashMap<>();
	static {
		for(UserRole role: UserRole.values()) {
			roleNameMapByType.put(role.getType(), role.name());
		}
	}
	
	UserRole(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
	public static String getRoleNameByType(int type) {
		return roleNameMapByType.get(type);
	}
	public static Role getRoleByType(int type) {
		return new Role(type, roleNameMapByType.get(type));
	}
}
