package br.com.caio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caio.data.vo.v1.PersonVO;
import br.com.caio.data.vo.v2.PersonVOV2;
import br.com.caio.exceptions.ResourceNotFoundException;
import br.com.caio.mapper.DozerMapper;
import br.com.caio.mapper.custom.PersonMapper;
import br.com.caio.models.Person;
import br.com.caio.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonMapper mapper;
	
	@Autowired
	private PersonRepository repository;
	
	public List<PersonVO> findAll() {
		List<Person> persons = repository.findAll();
		
		logger.info("findAll: total de pessoas = " + persons.size());
		
		return DozerMapper.parseListObjects(persons, PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		logger.info("findById: id = " + id);
		
		Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
	
		return DozerMapper.parseObject(person, PersonVO.class);
	}
	
	public PersonVO create(PersonVO personVo) {
		logger.info("create: person.id = " + personVo.getId());
		
		Person person = repository.save(DozerMapper.parseObject(personVo, Person.class));
		
		return DozerMapper.parseObject(person, PersonVO.class);
	}
	
	public PersonVOV2 create(PersonVOV2 personVo) {
		logger.info("create: person.id = " + personVo.getId());
		
		Person person = repository.save(DozerMapper.parseObject(personVo, Person.class));
		
		return mapper.convertEntityToVo(person);
	}
	
	public PersonVO update(PersonVO personVo) {
		logger.info("update: person.id = " + personVo.getId());
		
		Person person = DozerMapper.parseObject(findById(personVo.getId()), Person.class);
		person.setFirstName(personVo.getFirstName());
		person.setLastName(personVo.getLastName());
		person.setGender(personVo.getGender());
		person.setAddress(personVo.getAddress());
		
		return DozerMapper.parseObject(repository.save(person), PersonVO.class);
	}
	
	public void delete(Long id) {
		logger.info("delete: person.id = " + id);
		
		Person person = DozerMapper.parseObject(findById(id), Person.class);
		
		repository.delete(person);
	}
}
