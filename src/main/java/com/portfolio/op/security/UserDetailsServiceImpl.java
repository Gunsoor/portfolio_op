package com.portfolio.op.security;


import com.portfolio.op.dto.UserDto;
import com.portfolio.op.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
 
   		UserDto acoount = userMapper.findByUserId(userId);
		if (acoount == null) {
            throw new UsernameNotFoundException(userId);
        }
		return new UserDetailsImpl(acoount, getRole(acoount));
	}
	
	public List<GrantedAuthority> getRole(UserDto account) {
		
		if (account != null && account.getRole() != null) {
			List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
			roleList.add(new SimpleGrantedAuthority(account.getRole()));
			return roleList;
		}
		
		return null;
	}

}
