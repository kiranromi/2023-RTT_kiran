package com.kiran.capstone.techassistant.config;

import java.util.HashMap;
import java.util.Map;

import com.kiran.capstone.techassistant.entity.User;

public class UserSessionHandler {

	private static final Map<String, User> userMapByToken = new HashMap<>();
	private static final Map<Long, String> tokenMapByUserId = new HashMap<>();
	private static final Map<String, Long> userIdMapByToken = new HashMap<>();

	public static void addUser(String token, User user) {
		userMapByToken.put(token, user);
		tokenMapByUserId.put(user.getId(), token);
	}

	public static void addUser(User user) {
		String userToken = generateToken(user.getUsername(), String.valueOf(user.getPassword()));
		userMapByToken.put(userToken, user);
		tokenMapByUserId.put(user.getId(), userToken);
		userIdMapByToken.put(userToken, user.getId());
	}

	public static String getRoleByToken(String token) {
		User user = userMapByToken.get(token);
		if (user != null) {
			return user.getRole().getName();
		}
		return null;
	}

	public static String getTokenByUserid(Long userId) {
		return tokenMapByUserId.get(userId);
	}
	public static Long getUserIdByToken(String token) {
		return userIdMapByToken.get(token);
	}

	public static User getUserByToken(String token) {
		return userMapByToken.get(token);
	}

	private static String generateToken(String userName, String password) {
		return new String((userName + password).getBytes());
	}

	public static void removeUserSession(String token) {
		tokenMapByUserId.remove(userMapByToken.get(token).getId());
		userMapByToken.remove(token);
	}
}
