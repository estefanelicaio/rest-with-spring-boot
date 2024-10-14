package br.com.caio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caio.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
