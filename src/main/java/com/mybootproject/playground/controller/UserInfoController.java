package com.mybootproject.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.UserInfo;
import com.mybootproject.playground.repository.UserInfoRepository;

@RestController
public class UserInfoController {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/user")
	public UserInfo postUser(@RequestBody UserInfo user) {
		String clearPassword=user.getPassword();
		String encodedPassword=passwordEncoder.encode(clearPassword);
		user.setPassword(encodedPassword);
		
		return userInfoRepository.save(user);
		
	}
}
