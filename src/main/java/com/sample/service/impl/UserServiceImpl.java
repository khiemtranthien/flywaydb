package com.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bo.User;
import com.sample.entity.UserEntity;
import com.sample.repository.UserRepository;
import com.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		List<UserEntity> userEntities = userRepository.findAll();
		List<User> users = new ArrayList<User>();
		for(UserEntity entity : userEntities) {
			User u = new User();
			u.setAutoId(entity.getAutoId());
			u.setUserName(entity.getUserName());
			
			users.add(u);
		}
		
		return users;
	}

}
