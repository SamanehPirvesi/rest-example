package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class Phonebook {
	private int id;
	private String phonebookName;
	private String number;
//	@JsonIgnore
//	@JsonManagedReference
//	@JsonIdentityInfo(generator =ObjectIdGenerators.IntSequenceGenerator.class,property="@id")
	@JsonIgnore
	private User user;

	public Phonebook() {

	}

	

	public Phonebook(int id, String phonebookName, String number) {
		super();
		this.id = id;
		this.phonebookName = phonebookName;
		this.number = number;
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getPhonebookName() {
		return phonebookName;
	}



	public void setPhonebookName(String phonebookName) {
		this.phonebookName = phonebookName;
	}



	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
