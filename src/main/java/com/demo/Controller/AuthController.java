package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.AuthRequest;
import com.demo.Entity.User;
import com.demo.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public User signup(@RequestBody User user)
	{
		return authService.signup(user);
	}
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public String login(@RequestBody AuthRequest request)
	{
		return authService.login(request);
	}
	
	

}
