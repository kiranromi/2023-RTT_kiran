package com.kiran.artcollectorregistration.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kiran.artcollectorregistration.model.ArtCollector;
import com.kiran.artcollectorregistration.model.Role;
import com.kiran.artcollectorregistration.repoInterface.ArtCollectorsRepository;
import com.kiran.artcollectorregistration.repoInterface.RoleRepository;

@Service
public class ArtCollectorsServiceImpl implements ArtCollectorService {
	private ArtCollectorsRepository artCollectorsRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	
	public ArtCollectorsServiceImpl(ArtCollectorsRepository artCollectorsRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.artCollectorsRepository = artCollectorsRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void saveArtCollector(ArtCollector artCollector) {
	 
		// Encrypt the password using Spring Security
		//Getting password from artCollector first and encoding and then setting again into artCollector.
		
	  artCollector.setPassword(passwordEncoder.encode(artCollector.getPassword()));
	
	  // Check and set role USER if not already assigned
      checkRoleExist(artCollector);		
		
		artCollectorsRepository.save(artCollector);  // Now artCollector will save here in DB
	}
	private void checkRoleExist(ArtCollector artCollector) {
		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null) {          // if role not found then creating new role and saving in db
		    role = new Role();
			role.setName("ROLE_USER");
			roleRepository.save(role);
		}
		artCollector.setRoles(Arrays.asList(role));		// Adding role into artCollector
	    
	}
	  
		
	


	@Override
	public ArtCollector findArtCollectorByEmail(String email) {
		
		return artCollectorsRepository.findByEmail(email);
	}


	@Override
	public List<ArtCollector> findAllArtCollector() {
		List<ArtCollector> artcollectors = artCollectorsRepository.findAll();
		return artcollectors;
	
	}
}

