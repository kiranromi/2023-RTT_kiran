package com.kiran.artcollectorregistration.repoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.artcollectorregistration.model.ArtCollector;

public interface ArtCollectorsRepository extends JpaRepository<ArtCollector, Long>{

	
	ArtCollector findByEmail(String email);
}
