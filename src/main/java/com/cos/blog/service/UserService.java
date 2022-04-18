package com.cos.blog.service;


import com.cos.blog.model.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void 회원가입(User user)
	{
		String rawPassword = user.getPassword();
		String encodedPassword = encoder.encode(rawPassword);
		user.setPassword(encodedPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
		/*
		 * try { userRepository.save(user); return 1; }catch(Exception e) {
		 * e.printStackTrace(); System.out.println("UserService : 회원가입: "
		 * +e.getMessage() ); } return -1;
		 */
	}
	
}
