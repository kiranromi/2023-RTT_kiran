package com.kiran.capstone.techassistant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiran.capstone.techassistant.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

	@Modifying

	@Query("UPDATE Interview i SET i.interviewerId = :interviewerId, i.status = :status WHERE i.id = :interviewId")
	int assignInterviewToUser(@Param("interviewerId") Long interviewerId, @Param("status") int status, @Param("interviewId") Long interviewId);
	
	List<Interview> findAllByOrderByStatus();
	
	List<Interview> findByStatus(int status);
	
	List<Interview> findByStatusIn(List<Integer> statusList);
	
	List<Interview> findByStatusInOrderByStatus(List<Integer> statusList);

	Optional<Interview> findById(Long interviewId);

	List<Interview> findInterviewsByInterviewerId(Long interviewerId);

	List<Interview> findByInterviewerIdAndStatus(Long interviewId, int status);

	List<Interview> findInterviewsByEmployerId(Long employerId);

	List<Interview> findByEmployerIdAndStatus(Long employerId, int status);

	@Modifying
	@Query("UPDATE Interview i SET i.status = :status  WHERE i.id = :interviewId")
	int declineInterview(@Param("interviewId") Long interviewId, @Param("status") int status);

	@Modifying
	@Query("UPDATE Interview i SET i.isSelected = :isSelected, i.feedback = :feedback, i.status = :status WHERE i.id = :interviewId")
	int provideFeedback(
	    @Param("interviewId") Long interviewId,
	    @Param("isSelected") int isSelected,
	    @Param("feedback") String feedback,
	    @Param("status") int status
	);
}
