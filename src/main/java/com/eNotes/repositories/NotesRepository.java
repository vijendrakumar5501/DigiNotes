package com.eNotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eNotes.entities.Notes;
import com.eNotes.entities.UserDtls;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
//	 public  UserDtls  findByEmail(String email);
	
	

}
