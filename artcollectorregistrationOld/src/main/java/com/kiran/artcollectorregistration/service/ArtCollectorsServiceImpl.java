package com.kiran.artcollectorregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kiran.artcollectorregistration.model.ArtCollector;
import com.kiran.artcollectorregistration.model.Role;
import com.kiran.artcollectorregistration.repository.ArtCollectorsRepository;
import com.kiran.artcollectorregistration.repository.RoleRepository;

@Service
public class ArtCollectorsServiceImpl implements ArtCollectorService{
	
	  private  ArtCollectorsRepository artCollectorsRepository;
	  private  RoleRepository roleRepository;
	  private  PasswordEncoder passwordEncoder;

	    
	    public ArtCollectorsServiceImpl(ArtCollectorsRepository artCollectorsRepository,
	                                    RoleRepository roleRepository,
	                                    PasswordEncoder passwordEncoder) {
	        this.artCollectorsRepository = artCollectorsRepository;
	        this.roleRepository = roleRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public void saveArtCollector(ArtCollector artCollector) {
	        // Encode the password before saving
	        artCollector.setPassword(passwordEncoder.encode(artCollector.getPassword()));

	        // Check and set role USER if not already assigned
	        checkRoleExist(artCollector);

	        artCollectorsRepository.save(artCollector);
	    }

	    @Override
	    public ArtCollector findArtCollectorByEmail(String email) {
	        return artCollectorsRepository.findArtCollectorByEmail(email);
	    }

	    @Override
	    public List<ArtCollector> findAllArtCollector() {
	        return artCollectorsRepository.findAll();
	    }

	    // Add method to check and set role USER if not already assigned
	    private void checkRoleExist(ArtCollector artCollector) {
	        Role userRole = roleRepository.findByName("ROLE_USER");

	        if (userRole == null) {
	            userRole = new Role("ROLE_USER");
	            roleRepository.save(userRole);
	        }

	        if (!artCollector.getRoles().contains(userRole)) {
	            artCollector.getRoles().add(userRole);
	        }
	    }

	

	}




