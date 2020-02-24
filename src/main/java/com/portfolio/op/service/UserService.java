package com.portfolio.op.service;


import com.portfolio.op.dto.UserDto;

public interface UserService {
	public void insertUser(UserDto user);

	public String idCheck(String userId);

	public UserDto findByUserId(String userId);
}
