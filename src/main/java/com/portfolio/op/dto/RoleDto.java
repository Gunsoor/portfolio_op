package com.portfolio.op.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("roleDto")
public class RoleDto {
	private int roleSeq;
	private String roleAuth;
	private String roleNm;
	private String userType;
}
