package com.user.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userservice.model.UserBean;
import com.user.userservice.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	public UserBean saveUser(UserBean user) throws Exception {
		return userRepo.save(user);
	}

	public List<UserBean> getAllUsers() throws Exception {
		return userRepo.findAll();
	}

}
