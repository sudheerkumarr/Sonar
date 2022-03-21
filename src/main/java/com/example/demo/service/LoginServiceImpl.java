package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Login;
import com.example.demo.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	@Override
	public Login login(Login login) {
		// Get db account details
		Login dbLogin= loginRepo.getById(login.getEmail());
		// compare login and dbLogin details
		if(login.getEmail().equals(dbLogin.getEmail()) && login.getPassword().equals(dbLogin.getPassword())) {
			// Update isLogin flag to true
			dbLogin.setLogin(true);
			loginRepo.save(dbLogin);
			// return updated login object
			return dbLogin;
		}
		return null;
	}

	@Override
	public Login logout(String email) {
		Login login = loginRepo.getById(email);
		login.setLogin(false);
		return loginRepo.save(login);
		
	}

	@Override
	public void resetPassword(String email) {
		
		
	}

	@Override
	public Login forgotPassword(String email) {
		
		return null;
	}
	


}
