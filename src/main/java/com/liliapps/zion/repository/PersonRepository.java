package com.liliapps.zion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liliapps.zion.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
