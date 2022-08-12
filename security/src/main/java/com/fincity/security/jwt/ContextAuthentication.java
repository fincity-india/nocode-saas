package com.fincity.security.jwt;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContextAuthentication implements Authentication {

	private static final long serialVersionUID = 1127850908587759885L;

	private final ContextUser user;
	private boolean isAuthenticated;
	private final BigInteger loggedInFromClientId;
	private final String clientType;

	@Override
	public String getName() {
		if (user == null)
			return null;
		return user.getFirstName();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (user == null)
			return List.of();
		return user.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return user;
	}

}
