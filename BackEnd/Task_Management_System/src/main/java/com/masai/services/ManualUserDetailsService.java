package com.masai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.masai.model.User;
import com.masai.repository.UserRepository;

public class ManualUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = ur.findByUsername(username);
		if(user.isEmpty()) throw new UsernameNotFoundException("User not Found");
		User us = user.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		SimpleGrantedAuthority auth = new SimpleGrantedAuthrity("ROLE" + us.getRole().toUpperCase());
		org.springframework.security.core.userdetails.User secUser = new org.springframework.security.core.userdetails.User(us.getUsername(), us.getPassword(), authorities);
	return secUser;
	}
	

}
