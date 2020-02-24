package com.portfolio.op.mapper;

import com.portfolio.op.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
	int insertUser(UserDto users);

	int insertRoles(UserDto user);

	String idCheck(String userId);
	
	UserDto findByUserId(String userId);
}
