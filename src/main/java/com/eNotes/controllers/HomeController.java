package com.eNotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eNotes.entities.UserDtls;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {
	
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
    	 System.out.print(user);
    	 
    	 return "redirect:/signup";
		
	}
}
