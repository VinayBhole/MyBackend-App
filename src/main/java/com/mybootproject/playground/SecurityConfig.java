package com.mybootproject.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		/*auth.inMemoryAuthentication()
		.withUser("harry").password(getPasswordEncoder().encode("potter123")).roles("ADMIN")
		.and()
		.withUser("ronald").password(getPasswordEncoder().encode("weasley123")).roles("EXEC");*/
		auth.authenticationProvider(customAuthProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/category").permitAll()
		.antMatchers(HttpMethod.GET, "/product/category/{cid}").hasAnyAuthority("ADMIN")
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf()
		.disable();
     }
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	public DaoAuthenticationProvider customAuthProvider() {
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailsService);
		return dao;
	}
}