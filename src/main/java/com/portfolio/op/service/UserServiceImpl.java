package com.portfolio.op.service;

import com.portfolio.op.dto.UserDto;
import com.portfolio.op.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserMapper userMapper;

	@Override
	public void insertUser(UserDto user) {

	}

	@Override
	public String idCheck(String userId) {
		return userMapper.idCheck(userId);
	}

	@Override
	public UserDto findByUserId(String userId) {
		return userMapper.findByUserId(userId);
	}
}
