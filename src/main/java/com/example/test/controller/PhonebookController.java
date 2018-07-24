package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Phonebook;
import com.example.test.model.User;
import com.example.test.service.PhonebookService;

@RestController
@RequestMapping("/users/{userId}/phonebooks")
public class PhonebookController {
	private PhonebookService phonebookService;
	
	@Autowired // writing it explicitely is optional 
	public PhonebookController(PhonebookService phonebookService) {
	this.phonebookService = phonebookService;
	}


	@GetMapping("/{phonebookId}")
	public Phonebook getPhonebookById(@PathVariable("userId") int userId,@PathVariable("phonebookId") int phonebookId) {
	return phonebookService.getPhonebookById(userId,phonebookId);
	}
	
	@GetMapping()
	public List<Phonebook> getPhonebooksOfUser(@PathVariable("userId") int userId) {
	return phonebookService.getAllPhonebooksForUser(userId);
	}
	
	@PostMapping()
 public void addPhonebook(@PathVariable("userId") int userId  , @RequestBody Phonebook ph) {
	 phonebookService.saveNewPhonebook(userId, ph);
 }
	@PutMapping()
	public void updatePhonebook(@PathVariable("userId") int userId,@RequestBody Phonebook ph) {
		phonebookService.updatePHonebook(userId,ph);
				
	}
	@DeleteMapping("/{phonebookId}")
	public void deletePhonebook(@PathVariable("userId") int userId,@PathVariable("phonebookId") int phonebookId) {
		phonebookService.deletePhonebook(userId , phonebookId);	
	}
	
	
}
