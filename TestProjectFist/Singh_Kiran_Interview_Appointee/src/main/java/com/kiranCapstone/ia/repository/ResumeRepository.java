package com.kiranCapstone.ia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiranCapstone.ia.entity.Resume;

//public interface ResumeRepository extends CrudRepository<Resume, Long> {
public interface ResumeRepository extends JpaRepository<Resume, Long> {


}