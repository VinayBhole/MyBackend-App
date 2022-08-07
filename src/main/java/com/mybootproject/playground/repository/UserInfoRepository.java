package com.mybootproject.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootproject.playground.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	
	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String username);

}
