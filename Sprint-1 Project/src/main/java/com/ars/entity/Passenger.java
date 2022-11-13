package com.ars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = { "email"}) })
public class Passenger extends User{


@Column(length = 50)
private String name;

@Column(length = 10)
private String phno;

@Column(length = 100)     //@Column(unique = true,nullable=false)
private String email;

@Builder
public Passenger(int id, String UserName, String password, String role, String name, String phno, String email) {
	super(id, UserName, password, role);
	this.name = name;
	this.phno = phno;
	this.email = email;
}



}
