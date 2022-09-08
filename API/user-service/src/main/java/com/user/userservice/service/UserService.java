package com.user.userservice.service;

import java.util.List;
import com.user.userservice.model.UserBean;

public interface UserService {
	
	UserBean saveUser(UserBean user) throws Exception;
	
	List<UserBean> getAllUsers() throws Exception;

}
