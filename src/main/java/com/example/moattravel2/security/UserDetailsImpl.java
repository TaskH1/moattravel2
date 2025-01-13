package com.example.moattravel2.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.moattravel2.entity.User;


public class UserDetailsImpl implements UserDetails{
	private final User user;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
		
	}
	
	public User getUser() {
		return user;
	}
	
	//Return hashed password
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	//Return user name using when loggin in
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	//Return collection of role
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	//Return true unless account is expired
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//Return true unless user is locked
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//Return true unless password is expired
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//Return true is user is enabled
	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}

}
