package com.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.User;
import com.demo.Service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/csrf")
	public CsrfToken getToken(HttpServletRequest request) {

		return (CsrfToken) request.getAttribute("_csrf");

	}

	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{email}")
	@ResponseStatus(code = HttpStatus.OK)
	public User getEmployeeById(@PathVariable String email) {
		Optional<User> user = userService.getUserByEmail(email);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RuntimeException("User not found with provided email:" + email);
		}
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public User updateUser(@RequestBody User user) {

		if (user.getEmail() == null) {
			throw new RuntimeException("User is missing. Cannot update.");
		}

		return userService.updateUser(user);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@DeleteMapping("/{email}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUserByEmail(@PathVariable String email) {
		userService.deleteUserByEmail(email);

	}

}
