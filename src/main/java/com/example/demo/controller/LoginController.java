package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Login;
import com.example.demo.service.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	ILoginService loginServ;

	@PostMapping("/login")
	ResponseEntity<Login> login(@Valid @RequestBody Login login) {
		Login log = loginServ.login(login);
		return new ResponseEntity<>(log, HttpStatus.OK);
	}

	@GetMapping("/logout/{email}")
	ResponseEntity<Login> logout(@PathVariable("email") String email) {
		Login login = loginServ.logout(email);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
}
