package com.kiran.artcollectorregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.artcollectorregistration.model.ArtCollector;


public interface ArtCollectorsRepository extends JpaRepository<ArtCollector, Long>{
	public ArtCollector findArtCollectorByEmail(String email);
	
	

}
