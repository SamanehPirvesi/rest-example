package com.example.test.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class User {
	private int id;
	private String name;
	private String surnmae;
	private int age;
	
	@JsonIgnore
	//@JsonBackReference
//	@JsonIdentityInfo(generator =ObjectIdGenerators.None.class)
     private List<Phonebook> phonebooks=new ArrayList<>();

	public User() {

	}

	public User(int id,String name, String surnmae, int age) {

		this.name = name;
		this.surnmae = surnmae;
		this.age = age;
		this.id=id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnmae() {
		return surnmae;
	}

	public void setSurnmae(String surnmae) {
		this.surnmae = surnmae;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
public List<Phonebook> getPhonebooks() {
		return phonebooks;
	}

	public void setPhonebooks(List<Phonebook> phonebooks) {
		this.phonebooks = phonebooks;
	}

public void addPhonebook(Phonebook ph) {
	phonebooks.add(ph);
}

}
