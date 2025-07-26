package com.eNotes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.eNotes.entities.UserDtls;
import com.eNotes.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	 private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		 UserDtls userDtls= userRepository.findByEmail(username);
		 if(userDtls==null) {
			 throw new UsernameNotFoundException("user nont fond");
		 }else {
			 CustomUserDtls customUserDtls=new CustomUserDtls(userDtls);
			 return customUserDtls;
		 }
		
	}

}
