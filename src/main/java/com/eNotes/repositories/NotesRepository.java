package com.eNotes.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eNotes.entities.Notes;


public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
//	 public  UserDtls  findByEmail(String email);
	@Query("from Notes as n where n.userDtls.id=:uid")
	Page<Notes> findNotesByUser(@Param("uid") long uid,Pageable p);
	
	

}
