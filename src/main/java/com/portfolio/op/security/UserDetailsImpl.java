package com.portfolio.op.security;


import com.portfolio.op.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 476017985975105490L;
	
	private UserDto user;
	private Collection<? extends GrantedAuthority> roleList;
	


	public UserDetailsImpl(UserDto user, Collection<? extends GrantedAuthority> roleList) {
		super();
		this.user = user;
		this.roleList = roleList;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getRoleList() {
		return roleList;
	}

	public void setRoleList(Collection<? extends GrantedAuthority> roleList) {
		this.roleList = roleList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roleList;
	}

	@Override
	public String getPassword() {
		return user.getPwd();
	}

	@Override
	public String getUsername() {
		return user.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
