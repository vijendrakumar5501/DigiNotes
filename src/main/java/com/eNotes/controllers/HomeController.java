package com.eNotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eNotes.entities.UserDtls;
import com.eNotes.repositories.UserRepository;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
     @GetMapping("/")
	public String home() {
		return "home";
	}
     
     
     
     @GetMapping("/login")
 	public String login() {
 		return "login";
 	}
     
     
     @GetMapping("/signup")
 	public String signup() {
 		return "signup";
 	}
     
     @PostMapping("/saveUser")
     public String saveUser(@ModelAttribute UserDtls user, Model m) {
    	user.setPassword( passwordEncoder.encode(user.getPassword()));
    	user.setRole("ROLE_USER");
    	 userRepository.save(user);
    	 
    	 return "redirect:/login";
    	 
    	
		
	}
}
