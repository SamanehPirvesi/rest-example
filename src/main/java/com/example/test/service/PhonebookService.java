package com.example.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.model.Phonebook;
import com.example.test.model.User;
@Service
public class PhonebookService {
	
	private UserService userService;	
	
	public PhonebookService(UserService userService) {		
		this.userService=userService;
	}
	
	public Phonebook getPhonebookById(int userId, int phonebookId){
		return userService.getUserById(userId)
				.getPhonebooks()
				.stream()
				.filter(p -> p.getId()==phonebookId)
				.findFirst()
				.get();
	}
	public List<Phonebook> getAllPhonebooksForUser(int userId){
		User user=userService.getUserById(userId);
		return user.getPhonebooks();
	}
	public void saveNewPhonebook( int userId, Phonebook ph) {
		User user=userService.getUserById(userId);
		user.addPhonebook(ph);
		ph.setUser(user);
				
	}
	public void updatePHonebook(int userId,Phonebook ph ) {
		userService.getUserById(userId)
		         .getPhonebooks().stream()
				.filter(f->f.getId()==ph.getId())
				.forEach(phonebook ->{
					phonebook.setPhonebookName(ph.getPhonebookName());
					phonebook.setNumber(ph.getNumber());
						
				});
		
	}
 	
 	public void deletePhonebook( int userId ,int id) {
 		User user=userService.getUserById(userId);
 	user.getPhonebooks().removeIf(ph-> {
 			if (ph.getId()==id) {
 				return true;
 			}
 			return false;
 		});
 		
 	}

}



