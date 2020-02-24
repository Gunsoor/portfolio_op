package com.portfolio.op.security;


import com.google.gson.Gson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	Gson gson = new Gson();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException exception) throws IOException, ServletException {
		
		Map<String, String> resultMap = new HashMap<>();
		
		resultMap.put("state", "fail");
		resultMap.put("returnUrl", "/login");	
		
		res.setContentType("text/html;charset=UTF-8");
		OutputStream out = res.getOutputStream();
		out.write(gson.toJson(resultMap).getBytes());
		
	}
}
