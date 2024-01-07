package com.kiran.capstone.techassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.capstone.techassistant.entity.InterviewerDetails;


@Repository
public interface InterviewDetailsRepository extends JpaRepository<InterviewerDetails, Long> {

	List<InterviewerDetails> findByAreaOfSME(String areaOfSME);
}
