package com.kiranCapstone.ia.service;

import java.util.List;

import com.kiranCapstone.ia.dto.request.InvoiceRequestDTO;
import com.kiranCapstone.ia.entity.Invoice;

public interface InvoiceService {

	public Invoice genarateInvoice(InvoiceRequestDTO invoiceRequestDTO) throws Exception;

	public List<Invoice> getEmployerInvoices(Long employerId);

	public List<Invoice> getInterviewerInvoices(Long interviewerId);

	public List<Invoice> listAllInvoices();
}
