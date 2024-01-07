package com.kiranCapstone.ia.util;

import java.util.HashMap;
import java.util.Map;

import com.kiranCapstone.ia.entity.User;

public class UserSessionHandler {

	private static final Map<String, User> roleMapByToken = new HashMap<>();
	private static final Map<Long, String> tokenMapByUserId = new HashMap<>();

	public static void addUser(String token, User user) {
		roleMapByToken.put(token, user);
		tokenMapByUserId.put(user.getId(), token);
	}

	public static void addUser(User user) {
		String userToken = generateToken(user.getUsername(), String.valueOf(user.getPassword()));
		roleMapByToken.put(userToken, user);
		tokenMapByUserId.put(user.getId(), userToken);
	}

	public static String getRoleByToken(String token) {
		User user = roleMapByToken.get(token);
		if (user != null) {
			return user.getRole().getName();
		}
		return null;
	}

	public static String getTokenByUserid(Long userId) {
		return tokenMapByUserId.get(userId);
	}

	public static User getUserByToken(String token) {
		return roleMapByToken.get(token);
	}

	private static String generateToken(String userName, String password) {
		return new String((userName + password).getBytes());
	}

	public static void removeUserSession(String token) {
		roleMapByToken.remove(token);
	}
}
