package com.liliapps.zion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.liliapps.zion.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "Select u from User u where u.email=:pemail")
	public User findByEmail(@Param("pemail") String email);
	
	@Query(value = "Select u from User u where u.username=:pusername")
	public User usernameExist(@Param("pusername") String username);
	
}
