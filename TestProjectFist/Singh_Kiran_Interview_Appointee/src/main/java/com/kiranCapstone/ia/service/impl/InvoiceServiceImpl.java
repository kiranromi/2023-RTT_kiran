package com.kiranCapstone.ia.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kiranCapstone.ia.dto.request.InvoiceRequestDTO;
import com.kiranCapstone.ia.entity.Interview;
import com.kiranCapstone.ia.entity.Invoice;
import com.kiranCapstone.ia.repository.InterviewRepository;
import com.kiranCapstone.ia.repository.InvoiceRepository;
import com.kiranCapstone.ia.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private InvoiceRepository invoiceRepository;
	private InterviewRepository interviewRepository;
	
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public Invoice genarateInvoice(InvoiceRequestDTO invoiceRequestDTO) throws Exception {
		Interview interview = interviewRepository.findById(invoiceRequestDTO.getInterviewId())
				.orElseThrow(() -> new Exception("Interview doesn't exist"));
		Invoice invoice = new Invoice();
		invoice.setInterviewId(interview.getId());
		invoice.setInterviewrId(interview.getInterviewerId());
		invoice.setEmployerId(interview.getEmployerId());
		invoice.setAmount(interview.getRate());
		if (invoiceRequestDTO.getDueDate() == null) {
			invoice.setDueDate(LocalDateTime.now().plusDays(30));
		} else {
			invoice.setDueDate(LocalDateTime.parse(invoiceRequestDTO.getDueDate(), formatter));
		}
//		invoice.setGeneratedBy(null);
		invoice.setGeneratedAt(LocalDateTime.now());
		return invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> getEmployerInvoices(Long employerId) {
		return invoiceRepository.findByEmployerId(employerId);
	}

	@Override
	public List<Invoice> getInterviewerInvoices(Long interviewerId) {
		return invoiceRepository.findByInterviewerId(interviewerId);
	}

	@Override
	public List<Invoice> listAllInvoices() {
		return invoiceRepository.findAll();
	}

}
