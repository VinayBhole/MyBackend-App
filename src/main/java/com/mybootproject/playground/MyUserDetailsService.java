package com.mybootproject.playground;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mybootproject.playground.model.UserInfo;
import com.mybootproject.playground.repository.UserInfoRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	private UserInfoRepository userInfoRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo uInfo=userInfoRepository.getByUsername(username);
		if(uInfo==null)
			throw new UsernameNotFoundException("invalid username!!");
		List<GrantedAuthority> list=new ArrayList<>();
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority(uInfo.getRole());
		User user=new User(uInfo.getUsername(), uInfo.getPassword(), list);
		return user;
	}

}

