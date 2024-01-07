package com.kiran.registrationlogin.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 public Role(String name) {
	 this.name = name;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
