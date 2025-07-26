package com.eNotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user/")
public class UserController {

	@GetMapping("/addNotes")
	public String home() {
		return "user/add_notes";
	}
	
	@GetMapping("/viewNotes")
	public String view() {
		return "user/view_notes";
	}

}
