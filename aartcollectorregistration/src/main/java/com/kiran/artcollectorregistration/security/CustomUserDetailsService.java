package com.kiran.artcollectorregistration.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kiran.artcollectorregistration.model.ArtCollector;
import com.kiran.artcollectorregistration.repoInterface.ArtCollectorsRepository;

@Service   // This annotation we use to let spring know this is service that provide some business functionallty .
//here we are using service of authorization
public class CustomUserDetailsService  implements UserDetailsService {
	 private ArtCollectorsRepository artCollectorsRepository;

	    public CustomUserDetailsService(ArtCollectorsRepository artCollectorsRepository){
	        this.artCollectorsRepository = artCollectorsRepository;
	    }
		// It implements the UserDetailsService interface, which is part of Spring
		// Security.
		// The class has a constructor that takes an instance of ArtCollectorRepository
		// as a parameter.
		// This repository is presumably responsible for interacting with the data store
		// (e.g., a database) to retrieve information about art collectors.
	
	    @Override    // LoadUserByUsername Method
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {  // LoadUserByUsername Method

	        ArtCollector artCollector = artCollectorsRepository.findByEmail(email);
	        if(artCollector != null){
	            return new org.springframework.security.core.userdetails.User(artCollector.getUsername(),
	                    artCollector.getPassword(),
	                    artCollector.getRoles().stream()
	                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
	                            .collect(Collectors.toList()));

	        }else{
	            throw new UsernameNotFoundException("Invalid email or password");
	        }
	    }
	}
