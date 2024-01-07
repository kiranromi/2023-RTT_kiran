package com.kiranCapstone.ia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiranCapstone.ia.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByEmployerId(Long employerId);

	List<Invoice> findByInterviewerId(Long employerId);
}
