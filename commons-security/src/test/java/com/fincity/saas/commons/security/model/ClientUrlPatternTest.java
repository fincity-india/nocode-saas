package com.fincity.saas.commons.security.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientUrlPatternTest {

	@Test
	void test() {
	
		ClientUrlPattern pattern = new ClientUrlPattern("x", "ccode", "apps-dev.fincity.ai", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("apps-dev.fincity.ai", "443"));
		
		pattern = new ClientUrlPattern("x", "ccode", "https://apps-dev.fincity.ai:443", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("apps-dev.fincity.ai", "443"));
		
		pattern = new ClientUrlPattern("x", "ccode", "http://localhost:80", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "80"));
		
		pattern = new ClientUrlPattern("x", "ccode", "localhost:8080", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "443,8080"));
		
		pattern = new ClientUrlPattern("x", "ccode", "localhost", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "8011"));
		
		pattern = new ClientUrlPattern("x", "ccode", "https://localhost", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "443"));
		
		pattern = new ClientUrlPattern("x", "ccode", "https://localhost:20", "appcode");
		
		assertFalse(pattern.isValidClientURLPattern("localhost", "8011"));
		
		pattern = new ClientUrlPattern("x", "ccode", "localhost", "appcode");
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "443"));
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "80"));
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "443"));
		
		assertTrue(pattern.isValidClientURLPattern("localhost", "80"));
	}
}
