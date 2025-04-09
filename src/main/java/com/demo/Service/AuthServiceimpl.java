package com.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.AuthRequest;
import com.demo.Entity.User;
import com.demo.exceptions.InvalidCredentialsException;

@Service
public class AuthServiceimpl implements AuthService {

	@Autowired
	private UserService service;

	@Override
	public User signup(User user) {
		return service.saveUser(user);
	}

	@Override
	public String login(AuthRequest authRequest) {
		Optional<User> optional = service.getUserByEmail(authRequest.getEmailId());
		if (optional.isEmpty())
			throw new InvalidCredentialsException("Invalid Username");
		
		User user = optional.get();
		if(user.getPassword().equals(authRequest.getPassword()))
				return "Login successfully";
		else
			throw new InvalidCredentialsException("Invalid Password");
	}

}
