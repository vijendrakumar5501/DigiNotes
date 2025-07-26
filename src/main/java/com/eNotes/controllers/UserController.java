package com.eNotes.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eNotes.entities.Notes;
import com.eNotes.entities.UserDtls;
import com.eNotes.repositories.NotesRepository;
import com.eNotes.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NotesRepository notesRepository;

	@GetMapping("/addNotes")
	public String home() {
		return "user/add_notes";
	}

	@GetMapping("/viewNotes")
	public String view() {
		return "user/view_notes";
	}

	@GetMapping("/editNotes")
	public String edit() {
		return "user/edit_notes";
	}
	
@ModelAttribute
	public void addComData(Principal p, Model m) {
		String email = p.getName();
		UserDtls user=userRepository.findByEmail(email);
		m.addAttribute("user",user);
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}
	
	@PostMapping("/saveNotes")
	public String postMethodName(@ModelAttribute Notes note,Principal p) {
		String email=p.getName()
;
		UserDtls user=userRepository.findByEmail(email);
		note.setUserDtls(user);
		System.out.print(note);
		notesRepository.save(note);
		return "redirect:/user/addNotes";

	}
	

}
