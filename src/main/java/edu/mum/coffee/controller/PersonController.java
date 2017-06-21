package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {
//	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value="/personList", method = RequestMethod.GET)
	public String personList(Model model) {
		List<Person> personList = personService.findAll();
		model.addAttribute("personList",personList);
		return "personList";
	}
	
	@RequestMapping(value="/addPerson", method = RequestMethod.GET)
	public String addPerson(Model model) {
		return "addPerson";
	}
//	
//	@RequestMapping(value="/findPersonByEmail", method = RequestMethod.POST)
//	public void findPersonByEmail(@RequestBody String email ,Model model){
//		List<Person> personList = personService.findByEmail(email);
//		model.addAttribute(personList);
//	}
//	
//	@RequestMapping(value="/findPersonByID", method = RequestMethod.POST)
//	public void findPersonByID(@RequestBody Long id ,Model model){
//		Person person = personService.findById(id);
//		model.addAttribute(person);
//	}
//	
	@RequestMapping(value="/createPerson", method = RequestMethod.POST)
	public String createPerson(Person person, Model model){
		personService.savePerson(person);
		List<Person> personList = personService.findAll();
		model.addAttribute("personList",personList);
		return "personList";
	}
//	
//	@RequestMapping(value="/updateUser{id}", method = RequestMethod.POST)
//	public void updateUser(@RequestBody Person person, @PathVariable Long id){
//		Person p = personService.findById(id);
//		p.setAddress(person.getAddress());
//		p.setEmail(person.getEmail());
//		p.setFirstName(person.getFirstName());
//		p.setLastName(person.getLastName());
//		p.setPhone(person.getPhone());
//			
//	}
//	@RequestMapping(value="/deleteUser{id}", method = RequestMethod.GET)
//	public void delete(@PathVariable Long id, Model model){
//		personService.removePerson(personService.findById(id));
//	}
	
	

}
