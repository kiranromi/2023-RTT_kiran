package com.kiran.artcollectorregistration.service;

import java.util.List;

import com.kiran.artcollectorregistration.model.ArtCollector;

public interface ArtCollectorService {
	 void saveArtCollector(ArtCollector artCollector);
     ArtCollector findArtCollectorByEmail(String email);
     List<ArtCollector> findAllArtCollector();
	


}
