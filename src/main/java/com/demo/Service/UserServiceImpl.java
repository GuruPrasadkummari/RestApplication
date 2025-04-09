package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.User;
import com.demo.Repository.UserRepository;
import com.demo.exceptions.UserNotFoundException;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll() ;
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		if(userRepository.findById(email).isEmpty()) {
			throw new UserNotFoundException("User Not Found By Provided Email");
			
		}
		return userRepository.findById(email);
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserByEmail(String email) {
		if (userRepository.existsById(email)) {
			userRepository.deleteById(email);
		} else {
			throw new RuntimeException("User not found with provided email : " + email);
		}
	}

}
