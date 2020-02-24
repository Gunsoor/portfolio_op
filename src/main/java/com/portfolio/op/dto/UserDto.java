package com.portfolio.op.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userDto")
public class UserDto {
    private int userSeq;
    private String id;
    private String pwd;
    private String tel;
    private String nm;
    private String role;
}