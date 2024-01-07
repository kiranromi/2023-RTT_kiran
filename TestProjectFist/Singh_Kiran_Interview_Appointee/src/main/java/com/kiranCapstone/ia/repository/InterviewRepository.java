package com.kiranCapstone.ia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiranCapstone.ia.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

	@Modifying
	@Query("UPDATE Interview i SET i.interviewerId = :interviewerId WHERE i.id = :interviewId")
	int assignInterviewToUser(@Param("interviewerId") Long interviewerId, @Param("interviewId") Long interviewId);

	List<Interview> findByStatus(int status);

	Optional<Interview> findById(Long interviewId);

	List<Interview> findByInterviewerId(Long interviewerId);

	List<Interview> findByInterviewerIdAndStatus(Long interviewId, int status);

	List<Interview> findByEmployerId(Long employerId);

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
