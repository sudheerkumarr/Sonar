package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;
import com.example.demo.dto.EmpInputDto;
import com.example.demo.dto.EmpOutputDto;
import com.example.demo.dto.EmployeeDto;

public interface IEmployeeService {
	// get all employees
	List<Employee> getAllEmployees();
	//get emp based on id
	Employee getEmpById(int id);
	// get emp based on name
	Employee getEmpByName(String name);
	// add emp
	EmployeeDto addEmployee(Employee employee);
	EmpOutputDto addEmployeeDto(EmpInputDto employee);
	// update employee
	Employee updateEmployee(Employee employee);
	// delete employee
	Employee deleteEmpById(int id);
	// update emp name
	Employee updateEmpByName(int empId, String name);
	// update emp salary
	Employee updateEmpSalary(int id, double salary);
	
	// Add skill to employee
	Employee addSkillByEmpId(int empId, List<Skill> skills);
	//List<Employee> getAllEmpBasedOnSkillId(int skillId);
	List<EmpDto> getAllEmpBasedOnSkillId(int skillId);
	
}
