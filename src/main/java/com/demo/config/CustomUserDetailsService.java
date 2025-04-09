package com.demo.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.Entity.User;
import com.demo.Service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userByEmail = userService.getUserByEmail(username);
		if(userByEmail.isEmpty())
			throw new UsernameNotFoundException("Username not found with given email id: "+username);
		User user = userByEmail.get();
	UserDetails userdetal = new org.springframework.security.core.userdetails.User(
					username, encoder.encode(user.getPassword()), Arrays.asList(new SimpleGrantedAuthority("USER")));
		return userdetal;
	}

}
