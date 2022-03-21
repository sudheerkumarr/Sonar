package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpInputDto {
	
	private String empName;
	private String email;
	private String password;
	private String contactNo;

}
