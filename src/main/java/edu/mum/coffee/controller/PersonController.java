package edu.mum.coffee.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.RoleRepository;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.RoleService;
import edu.mum.coffee.service.UserService;

@Controller
public class PersonController {
	//
	@Autowired
	PersonService personService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    
	@RequestMapping(value = "/personList", method = RequestMethod.GET)
	public String personList(Model model) {
		List<Person> personList = personService.findAll();
		model.addAttribute("personList", personList);
		return "personList";
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.GET)
	public String addPerson(Model model) {
		return "addPerson";
	}

	@GetMapping({ "/deletePerson/{id}" })
	public String deletePerson(@PathVariable Long id, Model model) {
		personService.removePerson(personService.findById(id));
		List<Person> personList = personService.findAll();
		model.addAttribute("personList", personList);
		return "personList";
	}

	@RequestMapping(value = "/createPerson", method = RequestMethod.POST)
	public String createPerson(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String city, @RequestParam String state,
			@RequestParam String country, @RequestParam String zipcode, @RequestParam String phone,
			@RequestParam boolean enable, 
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String passwordConfirm,
			@RequestParam String role,Model model) {

		Address address = new Address(city, state, country, zipcode);
		Person person = new Person(firstName, lastName, email, address, phone, enable);
		Role r = new Role(role);
		User u = new User(username);

		
		person.setAddress(address);
		u.setPassword(password);
		u.setPasswordConfirm(passwordConfirm);
		
		Set<Role> roles = new HashSet<>();
		roles.add(r);
		u.setRoles(roles);
		roleService.save(r);
		userService.save(u);
		
		person.setUser(u);
		//person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
		//person.setRoles(new HashSet<>(roleRepository.findAll()));
		// Role role = new Role();
		// role.setName("ADMIN");
		// Set<Person> setRole = new HashSet<>();
		// setRole.add(person);
		// role.setUsers(setRole);
		//
		//
		personService.savePerson(person);
		List<Person> personList = personService.findAll();
		model.addAttribute("personList", personList);
		return "personList";
	}
	//
	// @RequestMapping(value="/findPersonByEmail", method = RequestMethod.POST)
	// public void findPersonByEmail(@RequestBody String email ,Model model){
	// List<Person> personList = personService.findByEmail(email);
	// model.addAttribute(personList);
	// }
	//
	// @RequestMapping(value="/findPersonByID", method = RequestMethod.POST)
	// public void findPersonByID(@RequestBody Long id ,Model model){
	// Person person = personService.findById(id);
	// model.addAttribute(person);
	// }
	////
	// @RequestMapping(value="/createPerson", method = RequestMethod.POST)
	// public String createPerson(@RequestParam Model model){
	//
	// personService.savePerson(person);
	// List<Person> personList = personService.findAll();
	// model.addAttribute("personList",personList);
	// return "personList";
	// }
	//
	// @RequestMapping(value="/updateUser{id}", method = RequestMethod.POST)
	// public void updateUser(@RequestBody Person person, @PathVariable Long
	// id){
	// Person p = personService.findById(id);
	// p.setAddress(person.getAddress());
	// p.setEmail(person.getEmail());
	// p.setFirstName(person.getFirstName());
	// p.setLastName(person.getLastName());
	// p.setPhone(person.getPhone());
	//
	// }
	// @RequestMapping(value="/deleteUser{id}", method = RequestMethod.GET)
	// public void delete(@PathVariable Long id, Model model){
	// personService.removePerson(personService.findById(id));
	// }

}
