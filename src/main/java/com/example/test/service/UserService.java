package com.example.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.model.User;

@Service
public class UserService {
 	private List<User> users;

	public UserService() {
		users=	new ArrayList<>();			
				
				users.add(new User(1,"samane","aaa",18));
				users.add(new User(2,"vahid","bbb",18));
				users.add(new User(3,"marco","ccc",20));
		
	}
	
	public User getUserById(int id) {
		return users.stream().filter(f->f.getId()==id).findFirst().orElse(null);
	}
	public List<User> getAllUsers(){
		return users;
	}
	public User saveNewUser(User u) {
		users.add(u);
		 return u;
	}
	public User updateUser(User u) {
		  users.stream()
				.filter(f->f.getId()==u.getId())
				.forEach(user ->{
					user.setName(u.getName());
					user.setSurnmae(u.getSurnmae());
					user.setAge(u.getAge());					
				});
		return u;
	}
 	
 	public void deleteUser(int id) {
 		users.removeIf(user-> {
 			if (user.getId()==id) {
 				return true;
 			}
 			return false;
 		});
 		
 	}
 	
 	

}
