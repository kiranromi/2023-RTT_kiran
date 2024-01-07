package com.kiranCapstone.ia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiranCapstone.ia.dto.request.InvoiceRequestDTO;
import com.kiranCapstone.ia.entity.Invoice;
import com.kiranCapstone.ia.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}


	@GetMapping("/")
	public String listAllInvoice(Model model) {
		model.addAttribute("invoice", invoiceService.listAllInvoices());
		return "redirect:/invoice_details";
	}
	
	@PostMapping("/")
	public String genarateInvoice(@ModelAttribute InvoiceRequestDTO requestDTO) throws Exception {
		invoiceService.genarateInvoice(requestDTO);
		return "redirect:/invoice_details";
	}
	
	@GetMapping("/employer/{employerId}")
	public String listEmployerInvoices(Model model, @PathVariable("employerId") long employerId) {
		List<Invoice> invoices = invoiceService.getEmployerInvoices(employerId);
		model.addAttribute("invoices", invoices);
		model.addAttribute("totalAmount", invoices.stream().mapToInt(Invoice::getAmount).sum());
		return "invoice_details";
	}

	@GetMapping("/interviewer/{interviewerId}")
	public String listInterviewerInvoices(Model model, @PathVariable("interviewerId") long interviewerId) {
		List<Invoice> invoices = invoiceService.getInterviewerInvoices(interviewerId);
		model.addAttribute("invoices", invoices);
		model.addAttribute("totalAmount", invoices.stream().mapToInt(Invoice::getAmount).sum());
		return "invoice_details";
	}
}
