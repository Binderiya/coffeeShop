package edu.mum.coffee.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.repository.PersonRepository;
import edu.mum.coffee.repository.RoleRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;


	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}

}
