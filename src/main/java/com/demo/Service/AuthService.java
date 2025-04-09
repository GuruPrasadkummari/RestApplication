package com.demo.Service;

import com.demo.Entity.AuthRequest;
import com.demo.Entity.User;

public interface AuthService {
	User signup(User user);
	String login(AuthRequest authRequest);

}
