package com.felps.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felps.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
}
