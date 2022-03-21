package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@Email(message="Invalid email address")
	private String email;
	@Size(min=8, max=25, message="Password length must be min 8 chars and max 25 chars")
	private String password;
	@JsonIgnore
	private boolean isLogin;
	
	
}
