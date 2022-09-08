package com.user.userservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.userservice.model.ResponseEntity;
import com.user.userservice.model.UserBean;
import com.user.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<UserBean> saveUser(@RequestBody UserBean user) throws Exception {

		ResponseEntity<UserBean> res = new ResponseEntity<UserBean>();
		UserBean user1 = null;

		user1 = userService.saveUser(user);

		if (user1 != null) {
			res.setStatus(200);
			res.setMessage("Data has been saved...");
			res.setData(user1);
		} else {
			res.setStatus(-1);
			res.setMessage("Something went wrong!");
			res.setData(user1);
		}
		return res;
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<UserBean>> getAllUsers() throws Exception {
		ResponseEntity<List<UserBean>> res = new ResponseEntity<List<UserBean>>();

		List<UserBean> userList = userService.getAllUsers();

		if (userList.size() > 0) {
			res.setMessage("User Records are retrieved successfully.");
			res.setStatus(200);
			res.setData(userList);
		} else {
			res.setMessage("Record Not Found!");
			res.setStatus(-1);
		}

		return res;
	}

}
