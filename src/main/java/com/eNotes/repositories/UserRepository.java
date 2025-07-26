package com.eNotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eNotes.entities.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
		 public UserDtls findByEmail(String email);
}
