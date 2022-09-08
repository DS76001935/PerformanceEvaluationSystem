package com.user.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.userservice.model.UserBean;

@Repository
public interface UserRepo extends JpaRepository<UserBean, Long> {

}
