package com.kiran.registrationlogin.entities;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String userName;
private String firstName;
private String lastName;
private String email;
private String phone;
private String zip;
private String password;

@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

@JoinTable(
        name = "users_roles", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )

private Collection <Role> roles;
public User(String userName, String firstName, String lastName, String email,
String phone, String zip, String password ) {
this.userName = userName;
this.firstName = firstName;
this.lastName = lastName;
this.email = email;
this.phone = phone;
this.zip = zip;
this.password = password;
}
}


