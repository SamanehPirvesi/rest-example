package com.example.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.exception.UserNotFoundException;
import com.example.test.model.User;
import com.example.test.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

   @GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int id) {
	   User u= userService.getUserById(id);
	   if(u==null) {
		   throw new UserNotFoundException("User does not exist ");
	   }
	   
	return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@GetMapping()
	
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<User> addUser(@RequestBody User u) {
		return new ResponseEntity<User>(userService.saveNewUser(u),HttpStatus.CREATED);
	}
	@PutMapping()
	public void updateUser(@RequestBody User u) {
		userService.updateUser(u);
	}
	@DeleteMapping("/{userId}")
	public void deleteUser (@PathVariable("userId") int id ) {
		userService.deleteUser(id);
	}
	
	
	
}
