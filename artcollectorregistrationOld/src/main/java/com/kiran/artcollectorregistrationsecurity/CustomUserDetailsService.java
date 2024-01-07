package com.kiran.artcollectorregistrationsecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kiran.artcollectorregistration.model.ArtCollector;
import com.kiran.artcollectorregistration.repository.ArtCollectorsRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	   private ArtCollectorsRepository artCollectorsRepository;

	    public CustomUserDetailsService(ArtCollectorsRepository artCollectorsRepository) {
	        this.artCollectorsRepository = artCollectorsRepository;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        ArtCollector artCollector = artCollectorsRepository.findArtCollectorByEmail(email);
	        if (artCollector == null) {
	            throw new UsernameNotFoundException("User not found with email: " + email);
	        }
	        return org.springframework.security.core.userdetails.User.builder()
	                .username(email)
	                .password(artCollector.getPassword())
	                .authorities(artCollector.getRoles().stream()
	                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
	                        .collect(Collectors.toList()))
	                .build();
	    
	   

	

        // Return UserDetails
       // return new UserDetails(artCollector.getEmail(), password, authorities);
    }
}
	    


