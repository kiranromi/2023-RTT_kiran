package com.kiran.password.passwordglabtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import junit.test.PasswordComply;

public class PasswordComplyTest {
	@Test
	void testDoesPasswordComply() {
		boolean expectedResult = true;
		PasswordComply password = new PasswordComply("abcd1234");
		boolean actualResult = password.doesPasswordComply();
		assertEquals(expectedResult,actualResult);
		System.out.println("Password conditions success!");
		}
	@Test
	void testDoesPasswordExist() {
	PasswordComply password = new PasswordComply("abcd1234");
	assertThrows(java.sql.SQLException.class,() ->
	password.doesNotAlreadyExist(), "SQL Exception was thrown.");
	}
	@Test
	void testEmptyPassword() {
	PasswordComply password = new PasswordComply("Abcd1234!");
	assertThrows(NullPointerException.class,() ->
	password.doesNotAlreadyExist(), "Null Exception was thrown but received SQL Exception.");
	}
	



}
