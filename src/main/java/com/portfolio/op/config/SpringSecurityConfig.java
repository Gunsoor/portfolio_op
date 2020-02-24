package com.portfolio.op.config;

import com.portfolio.op.security.LoginFailureHandler;
import com.portfolio.op.security.LoginSuccessHandler;
import com.portfolio.op.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import javax.sql.DataSource;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {



	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
	@Bean
	public LoginFailureHandler loginFailureHandler() {
		return new LoginFailureHandler();
	}
	@Bean
	public DefaultWebSecurityExpressionHandler webexpressionHandler() {
		return new DefaultWebSecurityExpressionHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
				/*.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT user_id, user_pwd, enabled "
                                    + "FROM user_t "
                                    + "WHERE user_id = ? AND enabled = 1 AND delete_yn = 'N'")
                .authoritiesByUsernameQuery("SELECT user_id, role "
                                          + "FROM user_t "
                                          + "WHERE user_id = ?")
                .passwordEncoder(passwordEncoder())
                .and()*/
				.userDetailsService(userDetailsServiceImpl)
				.passwordEncoder(passwordEncoder());



	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.securityContext()
				.and()
				.servletApi()
				.and()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user/**").hasAuthority("ROLE_USER")
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.and()
				.formLogin()
				.loginPage("/home/login")
				.usernameParameter("userId")
				.passwordParameter("userPwd")
				.loginProcessingUrl("/home/login")
				.successHandler(loginSuccessHandler())
				.failureHandler(loginFailureHandler())
				.and()
				.logout()
				.logoutUrl("/home/logout")
				.logoutSuccessUrl("/home/login")
				.and()
				.csrf();
	}




}
