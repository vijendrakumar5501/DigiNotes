package com.eNotes.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eNotes.entities.UserDtls;



public class CustomUserDtls implements UserDetails {
	
	private UserDtls userdtls;
	
	public CustomUserDtls(UserDtls userdtls) {
		super();
		this.userdtls=userdtls;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(userdtls.getRole());
		return Arrays.asList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userdtls.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method sstub
		return userdtls.getEmail();
	} 

}
