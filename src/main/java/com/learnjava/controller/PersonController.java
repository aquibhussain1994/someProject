package com.learnjava.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.model.Person;

@RestController
public class PersonController {

	List<Person> personList = new ArrayList<Person>();
	
	public  PersonController() {
		personList.add(new Person(1,"Aquib Hussain", 26));
		personList.add(new Person(2,"Saquib Hussain", 23));
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@GetMapping("/person")
	public List<Person> getAllPersons(){
		
		return personList;
	} 
	
	@GetMapping("/person/{personId}")
	public Person getPersonWithId(@PathVariable Integer personId){
		Person tempPerson = null;
       for(int i=0; i<personList.size(); i++) {
    	   if(personList.get(i).getId() == personId) {
    		   tempPerson = personList.get(i);
    	   }
       }
       return tempPerson;
	} 
	
	
	@PostMapping("/person/newperson")
	public String addPerson(@RequestBody Person person){
		personList.add(person);
		return "Saving person information";
	}

}
