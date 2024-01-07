package com.kiranCapstone.ia.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kiranCapstone.ia.constant.InterviewStatus;
import com.kiranCapstone.ia.constant.SupportedTechnology;
import com.kiranCapstone.ia.constant.UserRole;
import com.kiranCapstone.ia.dto.request.AddInterviewRequestDTO;
import com.kiranCapstone.ia.dto.request.FeedbackDTO;
import com.kiranCapstone.ia.entity.Interview;
import com.kiranCapstone.ia.entity.InterviewerDetails;
import com.kiranCapstone.ia.entity.Resume;
import com.kiranCapstone.ia.repository.InterviewDetailsRepository;
import com.kiranCapstone.ia.repository.InterviewRepository;
import com.kiranCapstone.ia.repository.ResumeRepository;
import com.kiranCapstone.ia.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

	private InterviewRepository interviewRepository;
	private InterviewDetailsRepository interviewDetailsRepository;
	private ResumeRepository resumeRepository;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public InterviewServiceImpl(InterviewRepository interviewRepository,
			InterviewDetailsRepository interviewDetailsRepository, ResumeRepository resumeRepository) {
		super();
		this.interviewRepository = interviewRepository;
		this.interviewDetailsRepository = interviewDetailsRepository;
		this.resumeRepository = resumeRepository;
	}

	@Override
	public Interview addInterview(AddInterviewRequestDTO dto) {
		Interview interview = new Interview();
		interview.setStatus(1);
		interview.setRate(SupportedTechnology.getInvoiceAmountByName(dto.getAreaOfSME()));
		interview.setEmployerId(dto.getEmployerId());
		interview.setInterviewDuration(dto.getInterviewDuration());
		interview.setAreaOfSME(dto.getAreaOfSME());
		interview.setCandidateContact(dto.getCandidateContact());
		interview.setCandidateName(dto.getCandidateName());
		interview.setYearOfExp(dto.getYearOfExp());
		interview.setInterviewStartAt(LocalDateTime.parse(dto.getInterviewStartAt(), formatter));
		interviewRepository.save(interview);
		uploadResume(dto.getFile(), interview.getId());
		return interviewRepository.save(interview);
	}

	@Override
	public int assignInterview(Long interviewerId, Long interviewId) {
		return interviewRepository.assignInterviewToUser(interviewerId, interviewId);
	}

	@Override
	public List<Interview> getAllActiveInterviewsByUserId(String userType, long userId) throws Exception {
		if (UserRole.INTERVIEWER.name().equalsIgnoreCase(userType)) {
			return interviewRepository.findByInterviewerIdAndStatus(userId, 1);
		} else if (UserRole.EMPLOYER.name().equalsIgnoreCase(userType)) {
			return interviewRepository.findByEmployerIdAndStatus(userId, 1);
		} else if (UserRole.ADMIN.name().equalsIgnoreCase(userType)) {
			return interviewRepository.findByStatus(1);
		} else {
			throw new Exception("Wrong UserType selected");
		}
	}

	@Override
	public List<String> getSupportedTechnologiesList() {
		SupportedTechnology[] technologiesArray = SupportedTechnology.values();
		List<SupportedTechnology> technologiesList = Arrays.asList(technologiesArray);
		List<String> supportedTechnologiesList = new ArrayList<>();
		for (SupportedTechnology technology : technologiesList) {
			supportedTechnologiesList.add(technology.name());
		}
		return supportedTechnologiesList;
	}

	@Override
	public List<InterviewerDetails> getInterviewersByTechnology(String technology) {
		return interviewDetailsRepository.findByAreaOfSME(technology);
	}

	@Override
	public int declineInterview(long id) {
		return interviewRepository.declineInterview(id, InterviewStatus.DECLINED.getStatus());
	}

	public Long uploadResume(MultipartFile file, Long interviewId) {
		try {
			Resume resume = new Resume();
			resume.setFileName(file.getOriginalFilename());
			resume.setFile(file.getBytes());
			resume.setInterviewId(interviewId);
			resumeRepository.save(resume);
			System.out.println("Uploaded Resume: " + file.getOriginalFilename());
			return resume.getId();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Resume getResumeById(Long resumeId) {
		return resumeRepository.findById(resumeId).orElse(null);
	}

	@Override
	public List<Interview> getAllInterviews() {
		return interviewRepository.findAll();
	}

	@Override
	public List<Interview> getAllActiveInterviews() {
		return interviewRepository.findByStatus(1);
	}

	@Override
	public List<Interview> getAllInterviewsByUserId(int userType, long userId) {
		if (userType == UserRole.INTERVIEWER.getType()) {
			return interviewRepository.findByInterviewerId(userId);
		} else if (userType == UserRole.EMPLOYER.getType()) {
			return interviewRepository.findByEmployerId(userId);
		} else {
			return interviewRepository.findByStatus(1);
		}
	}

	@Override
	public void provideFeedback(FeedbackDTO feedbackDTO) {
		interviewRepository.provideFeedback(feedbackDTO.getInterviewId(), feedbackDTO.getIsSelected(),
				feedbackDTO.getFeedback(), InterviewStatus.COMPLETED.getStatus());
	}
}
