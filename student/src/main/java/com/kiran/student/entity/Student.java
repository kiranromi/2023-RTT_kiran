package com.kiran.student.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
	public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		@Column(unique = true)
		private Long account;
		
		public Student() {
			super();
		}
		public Student(String name, Long account) {
			super();
			this.name = name;
			this.account = account;
		}
		public Student(Long id, String name, Long account) {
			super();
			this.id = id;
			this.name = name;
			this.account = account;
		}
		@Override
		public int hashCode() {
			return Objects.hash(account, id, name);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return Objects.equals(account, other.account) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name);
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getAccount() {
			return account;
		}
		public void setAccount(Long account) {
			this.account = account;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", account=" + account + "]";
		}
	}
	//@Data will contain all@Getter and @Setter @AllArgs and everything


