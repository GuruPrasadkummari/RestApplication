package com.demo.Service;

import java.util.List;
import java.util.Optional;

import com.demo.Entity.User;


public interface UserService {
	
	List<User>getAllUsers();
	Optional<User> getUserByEmail(String email);
	User saveUser(User user);
	User  updateUser(User user);
	void deleteUserByEmail(String email);

}
