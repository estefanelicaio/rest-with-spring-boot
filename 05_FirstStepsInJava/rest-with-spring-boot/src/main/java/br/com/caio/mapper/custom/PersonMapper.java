package br.com.caio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.caio.data.vo.v2.PersonVOV2;
import br.com.caio.models.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		
		return entity;
	}
	
}
