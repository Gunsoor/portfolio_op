package com.portfolio.op.security;


import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	Gson gson = new Gson();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
	throws IOException, ServletException {
		
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("state", "success");
		
		
		Collection<? extends GrantedAuthority> roleList = auth.getAuthorities();
		for(GrantedAuthority role : roleList) {
			if(role.getAuthority().equals("ROLE_GUEST")) {
				resultMap.put("returnUrl", "/home/login");
			}
			else if(role.getAuthority().equals("ROLE_USER")) {
				resultMap.put("returnUrl", "/user/main");
			}
			else if(role.getAuthority().equals("ROLE_SYS")) {
				resultMap.put("returnUrl", "/admin/main");
			}
			else if(role.getAuthority().equals("ROLE_ADMIN")) {
				resultMap.put("returnUrl", "/admin/main");
			}
		}
		
		
		OutputStream out = res.getOutputStream();
		out.write(gson.toJson(resultMap).getBytes("UTF-8"));
		
	}
}
