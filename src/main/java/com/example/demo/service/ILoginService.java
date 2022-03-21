package com.example.demo.service;

import com.example.demo.bean.Login;

public interface ILoginService {
	Login login(Login login);
	Login logout(String email);
	void resetPassword(String email);
	Login forgotPassword(String email);
}
