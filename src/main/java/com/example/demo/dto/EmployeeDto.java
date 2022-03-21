package com.example.demo.dto;

import com.example.demo.bean.Login;

import lombok.Data;

@Data
public class EmployeeDto {
	private String empName;
	private String contactNo;
	private LoginDto loginDto;
}
