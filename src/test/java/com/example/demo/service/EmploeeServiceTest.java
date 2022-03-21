package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;
import com.example.demo.dto.EmpInputDto;
import com.example.demo.dto.EmpOutputDto;
import com.example.demo.dto.EmployeeDto;

@SpringBootTest
class EmploeeServiceTest {

	@Autowired
	IEmployeeService empService;
	
	@Test
	void getAllEmployeesTest() {
		List<Employee> employees = empService.getAllEmployees();
		int noOfEmployees= employees.size();
		assertEquals(6, noOfEmployees);
	}
	
	@Test
	void getEmpByIdTest() {
		Employee employee = empService.getEmpById(37);
		assertEquals("9999966666", employee.getContactNo());
		assertEquals("RaJ", employee.getEmpName());
		assertEquals(25000, employee.getSalary());
		assertEquals(37, employee.getEmpId());
	}
	
	@Test
	@Disabled
	void addEmployeeDtoTest() {
		// create emp obj
		EmpInputDto empDto = new EmpInputDto();
		empDto.setEmpName("Bob");
		empDto.setEmail("bob@gmail.com");
		empDto.setContactNo("9999955555");
		empDto.setPassword("abc@1234");
		// persist emp obj
		EmpOutputDto empOutDto = empService.addEmployeeDto(empDto);
		// validate
		assertEquals("9999955555", empOutDto.getContactNo());
		assertEquals("Bob", empOutDto.getEmpName());
		assertEquals("bob@gmail.com", empOutDto.getEmail());
		
	}
	
		// get emp based on name
		@Test
		void getEmpByNameTest() {};

		// add emp
		@Test
		void addEmployeeTest() {};
		
		// update employee
		@Test
		void updateEmployeeTest() {};

		// delete employee
		@Test
		void deleteEmpByIdTest() {};

		//update emp name
		@Test
		void updateEmpByName() {};
		
		// update emp salary
		@Test
		void updateEmpSalaryTest() {};
		
		// Add skill to employee
		@Test
		void addSkillByEmpIdTest() {};
		
		//List<Employee> getAllEmpBasedOnSkillId(int skillId);
		@Test
		void getAllEmpBasedOnSkillIdTest() {};
	
	
	

}
