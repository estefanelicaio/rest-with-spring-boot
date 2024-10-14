package br.com.caio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caio.exceptions.ResourceNotFoundException;
import br.com.caio.models.Person;
import br.com.caio.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll() {
		List<Person> persons = repository.findAll();
		
		logger.info("findAll: total de pessoas = " + persons.size());
		
		return persons;
	}
	
	public Person findById(Long id) {
		logger.info("findById: id = " + id);
		
		Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
	
		return person;
	}
	
	public Person create(Person person) {
		logger.info("create: person.id = " + person.getId());
		
		repository.save(person);
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("update: person.id = " + person.getId());
		
		Person entity = findById(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("delete: person.id = " + id);
		
		repository.delete(findById(id));
	}
	
}
