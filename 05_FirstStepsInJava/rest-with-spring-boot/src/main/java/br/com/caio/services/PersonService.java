package br.com.caio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.caio.models.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			persons.add(mockPerson(i));
		}
		
		logger.info("findAll: total de pessoas = " + persons.size());
		
		return persons;
	}
	
	public Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Firstname " + i);
		person.setLastName("Lastname " + i);
		person.setGender(i % 2 == 0 ? "Masculino" : "Feminino");
		person.setAddress("Brasília - DF - Brasil");
		
		return person;
	}
	
	public Person findById(String id) {
		logger.info("findById: id = " + id);
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Caio");
		person.setLastName("Estefaneli");
		person.setGender("Masculino");
		person.setAddress("Brasília - DF - Brasil");
		
		return person;
	}
	
	public Person create(Person person) {
		logger.info("create: person.id = " + person.getId());
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("update: person.id = " + person.getId());
		
		return person;
	}
	
	public void delete(String id) {
		logger.info("delete: person.id = " + id);
	}
	
}
