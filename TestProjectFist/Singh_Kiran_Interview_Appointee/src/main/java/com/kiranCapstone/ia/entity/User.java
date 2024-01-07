package com.kiranCapstone.ia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "password", nullable = false)
	private byte[] password;

	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "is_active", nullable = false, columnDefinition = "tinyint default 1")
	private int isActive = 1;

	@Column(name = "user_type", nullable = false)
	private int userType;

	@Column(name = "address", nullable = true)
	private String address;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;

	public User() {
		super();
	}

	public User(Long id, String firstName, byte[] password, String userName, String lastName, String email,
			int isActive, int userType, String address, Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.password = password;
		this.userName = userName;
		this.lastName = lastName;
		this.email = email;
		this.isActive = isActive;
		this.userType = userType;
		this.address = address;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
